package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.controller.request.UserRequest;
import com.example.sample_spring_boot_project.user.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    Set<UserDTO> findAllUsers();
    Page<UserDTO> findAllUsers(Pageable pageable);
    UserDTO addUser(UserRequest request);
    UserDTO updateUser(UUID uuid, UserRequest request);
}
