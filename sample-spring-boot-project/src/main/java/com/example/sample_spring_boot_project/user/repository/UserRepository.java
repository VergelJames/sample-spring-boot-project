package com.example.sample_spring_boot_project.user.repository;

import com.example.sample_spring_boot_project.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("""
            SELECT u FROM User u WHERE u.status = 'ACT'
            """)
    Set<User> findAllActiveUser();

    @Query("""
            SELECT u FROM User u WHERE u.status = 'ACT'
            """)
    Page<User> findAllActiveUser(Pageable pageable);

    @Query("""
            SELECT u FROM User u WHERE u.status = 'ACT' AND u.uuid = :uuid
            """)
    Optional<User> findByUuid(@Param("uuid") UUID uuid);
}
