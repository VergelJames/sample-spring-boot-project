package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.controller.request.AddressRequest;
import com.example.sample_spring_boot_project.user.controller.request.UserRequest;
import com.example.sample_spring_boot_project.user.dto.AddressDTO;
import com.example.sample_spring_boot_project.user.model.Address;
import com.example.sample_spring_boot_project.user.model.User;
import com.example.sample_spring_boot_project.user.repository.AddressRepository;
import com.example.sample_spring_boot_project.user.repository.AddressTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressTypeRepository addressTypeRepository;
    private final AddressTypeService addressTypeService;

    public Address mapRequest(AddressRequest request, User user){

        return Address.builder()
                .user(user)
                .address1(request.getAddress1())
                .address2(request.getAddress2())
                .city(request.getCity())
                .state(request.getState())
                .zipCode(request.getZipCode())
                .typeUuid(this.addressTypeService.findAddressType(request.getAddressType()).getUuid())
                .build();
    }

    private AddressDTO mapEntity(Address entity, HashMap<UUID, String> types){
        return new AddressDTO(entity.getAddress1(), entity.getAddress2(), entity.getCity(), entity.getState(), entity.getZipCode(), types.get(entity.getTypeUuid()));
    }

    public Set<AddressDTO> findAllUserAddress(UUID userUuid) {
        Supplier<HashMap<UUID, String>> findTypes = () -> {
            HashMap<UUID, String> types = new HashMap<>();
            this.addressTypeRepository.findAllAddressType().forEach(d -> types.put(d.getUuid(), d.getName()));
            return types;
        };
        Set<AddressDTO> addresses = new HashSet<>();
        this.addressRepository.findUserAddresses(userUuid).ifPresentOrElse(existingAddress ->
                    addresses.addAll(existingAddress.stream().map(a ->
                            this.mapEntity(a, findTypes.get()))
                            .collect(Collectors.toSet())),
                () -> log.info("No Address"));
        return addresses;
    }
}
