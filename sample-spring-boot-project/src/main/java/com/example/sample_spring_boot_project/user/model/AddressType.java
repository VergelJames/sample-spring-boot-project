package com.example.sample_spring_boot_project.user.model;

import com.example.sample_spring_boot_project.user.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "address_type")
@Getter
public class AddressType extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "binary(16)")
    private UUID uuid;

    @Column(name = "name", updatable = false, insertable = false, columnDefinition = "varchar(50)")
    private String name;
}
