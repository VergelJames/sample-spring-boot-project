package com.example.sample_spring_boot_project.user.service;

import com.example.sample_spring_boot_project.user.model.AddressType;
import com.example.sample_spring_boot_project.user.repository.AddressTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressTypeServiceImpl implements AddressTypeService{

    private final AddressTypeRepository addressTypeRepository;

    public AddressType findAddressType(String type){
        AddressType addressType = addressTypeRepository.findAddressType(type).orElseThrow(() -> new NullPointerException("Type does not exists"));
        return addressType;
    }
}
