package com.emezon.transaction.app.dtos;

import com.emezon.transaction.domain.constants.SupplyConstrains;
import com.emezon.transaction.domain.constants.SupplyErrorMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSupplyDTO {

    @Min(value = SupplyConstrains.SUPPLY_QUANTITY_MIN_VALUE, message = SupplyErrorMessages.SUPPLY_QUANTITY_MIN_VALUE)
    private int quantity;

    @NotNull(message = SupplyErrorMessages.SUPPLY_ARTICLE_ID_REQUIRED)
    @NotBlank(message = SupplyErrorMessages.SUPPLY_ARTICLE_ID_REQUIRED)
    private String articleId;

    @Length(max = SupplyConstrains.SUPPLY_COMMENTS_MAX_LENGTH, message = SupplyErrorMessages.SUPPLY_COMMENTS_MAX_LENGTH)
    private String comments;

    @Min(value = SupplyConstrains.SUPPLY_COST_MIN_VALUE, message = SupplyErrorMessages.SUPPLY_COST_MIN_VALUE)
    private Double cost;

    private LocalDateTime restockDate;

}
