package com.example.sample_spring_boot_project.user.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @Column(name = "status", insertable = false, nullable = false, columnDefinition = "char(3)")
    private String status;

    @CreationTimestamp
    @Column(name = "when_added", nullable = false, updatable = false, columnDefinition = "datetime(6)")
    protected LocalDateTime whenAdded;

    @UpdateTimestamp
    @Column(name = "when_updated", nullable = false, insertable = false, columnDefinition = "datetime(6)")
    protected LocalDateTime whenUpdated;
}
