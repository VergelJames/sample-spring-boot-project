package com.example.sample_spring_boot_project.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {

    public AddressDTO(String address1, String address2, String city, String state, String zipCode) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String addressType;
}
