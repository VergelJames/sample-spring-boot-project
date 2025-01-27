package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.controller.request.UserRequest;
import com.example.sample_spring_boot_project.user.dto.UserDTO;
import com.example.sample_spring_boot_project.user.model.Address;
import com.example.sample_spring_boot_project.user.model.User;
import com.example.sample_spring_boot_project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;

    /**
     * Service for mapping User to UserDTO
     *
     * @param user User
     * @return UserDTO
     */
    private UserDTO mapUser(User user) {
        UserDTO dto = new UserDTO(user.getFirstName(), user.getMiddleName(), user.getLastName());
        dto.setAddresses(this.addressService.findAllUserAddress(user.getUuid()));
        return dto;
    }

    private User findUserByUuid(UUID uuid){
        return this.userRepository.findByUuid(uuid)
                .orElseThrow(() -> new NullPointerException("User does not exists"));
    }

    /**
     * Service for finding all users in set
     *
     * @return Set of UserDTO
     */
    public Set<UserDTO> findAllUsers() {
        Set<UserDTO> users = new HashSet<>();
        userRepository.findAllActiveUser().forEach(u -> users.add(this.mapUser(u)));
        return users;
    }

    /**
     * Service for finding users in paged
     *
     * @param pageable Pageable
     * @return Page of UserDTO
     */
    public Page<UserDTO> findAllUsers(Pageable pageable) {
        Page<User> pagedEntity = this.userRepository.findAllActiveUser(pageable);
        if (pagedEntity.isEmpty()) {
            return Page.empty();
        }
        return pagedEntity.map(this::mapUser);
    }

    @Transactional
    public UserDTO addUser(UserRequest request){
        User user = new User(request.getFirstName(), request.getMiddleName(), request.getLastName());
        user.setAddresses(request.getAddresses()
                .stream()
                .map(a -> this.addressService.mapRequest(a, user))
                .toList());
        return this.mapUser(this.userRepository.save(user));
    }

    @Transactional
    public UserDTO updateUser(UUID uuid, UserRequest request){
        User user = this.findUserByUuid(uuid);
        user.getAddresses().removeAll(user.getAddresses());
        user.getAddresses().addAll(request.getAddresses()
                .stream()
                .map(a -> this.addressService.mapRequest(a, user)).toList());
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        this.userRepository.save(user);
        return this.mapUser(user);
    }
}
