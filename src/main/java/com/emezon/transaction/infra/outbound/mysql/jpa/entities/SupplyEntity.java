package com.emezon.transaction.infra.outbound.mysql.jpa.entities;

import com.emezon.transaction.infra.outbound.mysql.jpa.constants.SupplyEntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity(name = SupplyEntityConstants.ENTITY_NAME)
@Table(name = SupplyEntityConstants.TABLE_NAME)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplyEntity {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String articleId;

    @Column(nullable = false)
    private String suppliedById;

    private String comments;

    private Double cost;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
