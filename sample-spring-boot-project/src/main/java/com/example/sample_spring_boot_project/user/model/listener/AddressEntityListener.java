package com.example.sample_spring_boot_project.user.model.listener;

import com.example.sample_spring_boot_project.user.model.Address;
import com.example.sample_spring_boot_project.user.model.User;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressEntityListener {

    @PrePersist
    private void address(Address address){
        address.setUuid(UUID.randomUUID());
    }
}
