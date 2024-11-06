package com.emezon.transaction.infra.outbound.mysql.jpa.mappers;

import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.infra.outbound.mysql.jpa.entities.SupplyEntity;

public class SupplyEntityMapper {

    public static SupplyEntity toEntity(Supply supply) {
        return SupplyEntity.builder()
                .id(supply.getId())
                .quantity(supply.getQuantity())
                .articleId(supply.getArticleId())
                .suppliedById(supply.getSuppliedById())
                .comments(supply.getComments())
                .cost(supply.getCost())
                .restockDate(supply.getRestockDate())
                .createdAt(supply.getCreatedAt())
                .updatedAt(supply.getUpdatedAt())
                .build();
    }

    public static Supply toDomain(SupplyEntity supplyEntity) {
        return Supply.builder()
                .id(supplyEntity.getId())
                .quantity(supplyEntity.getQuantity())
                .articleId(supplyEntity.getArticleId())
                .suppliedById(supplyEntity.getSuppliedById())
                .comments(supplyEntity.getComments())
                .cost(supplyEntity.getCost())
                .restockDate(supplyEntity.getRestockDate())
                .createdAt(supplyEntity.getCreatedAt())
                .updatedAt(supplyEntity.getUpdatedAt())
                .build();
    }

}
