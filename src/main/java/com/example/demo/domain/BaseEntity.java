package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {

    @CreatedDate
    public LocalDate createdAt;
    @LastModifiedDate
    public LocalDate updatedAt;

    public String createdBy;
    public String updatedBy;

    /*@PrePersist
    public void onPersist() {
        if (this.createdAt == null) {
            this.createdAt = this.updatedAt = LocalDate.now();
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDate.now();
    }*/
}
