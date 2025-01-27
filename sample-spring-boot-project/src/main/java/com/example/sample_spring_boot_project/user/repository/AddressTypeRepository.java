package com.example.sample_spring_boot_project.user.repository;

import com.example.sample_spring_boot_project.user.model.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, UUID> {


    @Query("""
            SELECT at FROM AddressType at
            """)
    Set<AddressType> findAllAddressType();


    @Query("""
            SELECT at FROM AddressType at WHERE at.name = :type
            """)
    Optional<AddressType> findAddressType(@Param("type") String type);
}
