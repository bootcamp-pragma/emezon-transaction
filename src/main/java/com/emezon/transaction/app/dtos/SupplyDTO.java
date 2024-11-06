package com.emezon.transaction.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDTO {

    private String id;
    private int quantity;
    private String articleId;
    private String suppliedById;
    private String comments;
    private Double cost;
    private LocalDateTime restockDate;
    private LocalDateTime createdAt;

}
