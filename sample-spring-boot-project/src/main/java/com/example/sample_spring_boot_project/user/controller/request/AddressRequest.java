package com.example.sample_spring_boot_project.user.controller.request;

import com.example.sample_spring_boot_project.user.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressRequest {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String addressType;
    private User user;
}
