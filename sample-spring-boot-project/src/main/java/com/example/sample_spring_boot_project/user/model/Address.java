package com.example.sample_spring_boot_project.user.model;

import com.example.sample_spring_boot_project.user.model.base.BaseModel;
import com.example.sample_spring_boot_project.user.model.listener.AddressEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.UUID;

@Entity
@EntityListeners(AddressEntityListener.class)
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends BaseModel {

    @Id
    @Column(name = "uuid", updatable = false, columnDefinition = "binary(16)")
    private UUID uuid;

    @Column(name = "address_line_1", nullable = false, columnDefinition = "text")
    private String address1;

    @Column(name = "address_line_2", nullable = true, columnDefinition = "text")
    private String address2;

    @Column(name = "city", nullable = false, columnDefinition = "varchar(255)")
    private String city;

    @Column(name = "state", nullable = false, columnDefinition = "varchar(255)")
    private String state;

    @Column(name = "zip_code", nullable = false, columnDefinition = "varchar(10)")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ReadOnlyProperty
    @JsonIgnore
    @Column(name = "user_uuid", insertable = false, updatable = false)
    private UUID userUuid;

    @Column(name = "type_uuid", nullable = false, columnDefinition = "binary(16)")
    private UUID typeUuid;
}
