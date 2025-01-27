package com.example.sample_spring_boot_project.user.model;

import com.example.sample_spring_boot_project.user.model.base.BaseModel;
import com.example.sample_spring_boot_project.user.model.listener.UserEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(UserEntityListener.class)
@Table(name = "samp_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel {
    public User(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Id
    @Column(name = "uuid", updatable = false, columnDefinition = "binary(16)")
    private UUID uuid;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(255)")
    private String firstName;

    @Column(name = "middle_name", nullable = false, columnDefinition = "varchar(255)")
    private String middleName;

    @Column(name = "last_name", nullable = false, columnDefinition = "varchar(255)")
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
