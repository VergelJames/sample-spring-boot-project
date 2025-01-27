package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.controller.request.AddressRequest;
import com.example.sample_spring_boot_project.user.controller.request.UserRequest;
import com.example.sample_spring_boot_project.user.dto.AddressDTO;
import com.example.sample_spring_boot_project.user.model.Address;
import com.example.sample_spring_boot_project.user.model.User;

import java.util.Set;
import java.util.UUID;

public interface AddressService {

    Set<AddressDTO> findAllUserAddress(UUID userUuid);
    Address mapRequest(AddressRequest request, User user);
}
