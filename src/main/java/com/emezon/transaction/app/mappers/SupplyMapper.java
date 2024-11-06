package com.emezon.transaction.app.mappers;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.domain.models.Supply;

public class SupplyMapper {

    private SupplyMapper() { }

    public static SupplyDTO toDTO(Supply supply) {
        if (supply == null) {
            return null;
        }
        SupplyDTO supplyDTO = new SupplyDTO();
        supplyDTO.setId(supply.getId());
        supplyDTO.setQuantity(supply.getQuantity());
        supplyDTO.setArticleId(supply.getArticleId());
        supplyDTO.setSuppliedById(supply.getSuppliedById());
        supplyDTO.setCost(supply.getCost());
        supplyDTO.setComments(supply.getComments());
        supplyDTO.setRestockDate(supply.getRestockDate());
        supplyDTO.setCreatedAt(supply.getCreatedAt());
        return supplyDTO;
    }

    public static Supply toModel(SupplyDTO supplyDTO) {
        if (supplyDTO == null) {
            return null;
        }
        return Supply.builder()
                .id(supplyDTO.getId())
                .quantity(supplyDTO.getQuantity())
                .articleId(supplyDTO.getArticleId())
                .suppliedById(supplyDTO.getSuppliedById())
                .cost(supplyDTO.getCost())
                .comments(supplyDTO.getComments())
                .createdAt(supplyDTO.getCreatedAt())
                .build();
    }

    public static Supply toModel(CreateSupplyDTO supplyDTO) {
        if (supplyDTO == null) {
            return null;
        }
        return Supply.builder()
                .quantity(supplyDTO.getQuantity())
                .articleId(supplyDTO.getArticleId())
                .cost(supplyDTO.getCost())
                .comments(supplyDTO.getComments())
                .restockDate(supplyDTO.getRestockDate())
                .build();
    }

}
