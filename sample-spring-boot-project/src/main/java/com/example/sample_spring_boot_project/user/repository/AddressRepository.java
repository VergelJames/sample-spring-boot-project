package com.example.sample_spring_boot_project.user.repository;

import com.example.sample_spring_boot_project.user.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID>{

    @Query("""
            SELECT a FROM Address a WHERE a.userUuid = :userUuid
            """)
    Optional<Set<Address>> findUserAddresses(@Param("userUuid") UUID userUuid);
}
