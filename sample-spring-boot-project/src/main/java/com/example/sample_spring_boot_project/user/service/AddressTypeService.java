package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.model.AddressType;

public interface AddressTypeService {
    AddressType findAddressType(String type);
}
