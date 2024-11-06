package com.emezon.transaction.infra.outbound.feign.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSupplyDTO {

    @NotNull(message = "The payload is required")
    @NotBlank(message = "The payload cannot be empty")
    private String payload;

}
