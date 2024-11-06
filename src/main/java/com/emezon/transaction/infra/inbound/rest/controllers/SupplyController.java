package com.emezon.transaction.infra.inbound.rest.controllers;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.app.handlers.ISupplyHandler;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.infra.inbound.rest.constants.PaginatedConstants;
import com.emezon.transaction.infra.inbound.rest.constants.RestApiConstants;
import com.emezon.transaction.infra.inbound.rest.utils.ValidPageableRequest;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(RestApiConstants.API_SUPPLY)
@RequiredArgsConstructor
public class SupplyController {

    private final ISupplyHandler supplyHandler;

    @GetMapping
    @Parameters({
            @Parameter(name = PaginatedConstants.PARAM_PAGE, description = PaginatedConstants.PARAM_PAGE_DESC, example = PaginatedConstants.PARAM_PAGE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SIZE, description = PaginatedConstants.PARAM_SIZE_DESC, example = PaginatedConstants.PARAM_SIZE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SORT, description = PaginatedConstants.PARAM_SORT_DESC,
                    array = @ArraySchema(schema = @Schema(type = "string", example = PaginatedConstants.PARAM_SORT_EXAMPLE)))
    })
    public ResponseEntity<PaginatedResponse<SupplyDTO>> getAllSupplies(
            @Parameter(hidden = true) @RequestParam @ValidPageableRequest(target = Supply.class) @Valid
            MultiValueMap<String, String> queryParams
    ) {
        PaginatedResponse<SupplyDTO> supplies = supplyHandler.getAllSupplies(queryParams);
        return ResponseEntity.ok(supplies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyDTO> getSupplyById(@PathVariable String id) {
        SupplyDTO supplyDTO = supplyHandler.getSupplyById(id);
        return ResponseEntity.ok(supplyDTO);
    }

    @PostMapping
    public ResponseEntity<SupplyDTO> createSupply(@RequestBody @Valid CreateSupplyDTO createSupplyDTO) {
        SupplyDTO supplyDTO = supplyHandler.createSupply(createSupplyDTO);
        URI location = URI.create(RestApiConstants.API_SUPPLY);
        return ResponseEntity.created(location).body(supplyDTO);
    }

    @GetMapping("/article/{articleId}")
    @Parameters({
            @Parameter(name = PaginatedConstants.PARAM_PAGE, description = PaginatedConstants.PARAM_PAGE_DESC, example = PaginatedConstants.PARAM_PAGE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SIZE, description = PaginatedConstants.PARAM_SIZE_DESC, example = PaginatedConstants.PARAM_SIZE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SORT, description = PaginatedConstants.PARAM_SORT_DESC,
                    array = @ArraySchema(schema = @Schema(type = "string", example = PaginatedConstants.PARAM_SORT_EXAMPLE)))
    })
    public ResponseEntity<PaginatedResponse<SupplyDTO>> getSuppliesByArticleId(
            @PathVariable String articleId,
            @Parameter(hidden = true) @RequestParam @ValidPageableRequest(target = Supply.class) @Valid
            MultiValueMap<String, String> queryParams
    ) {
        PaginatedResponse<SupplyDTO> supplies = supplyHandler.getSuppliesByArticleId(articleId, queryParams);
        return ResponseEntity.ok(supplies);
    }

    @GetMapping("/supplied-by/{userId}")
    @Parameters({
            @Parameter(name = PaginatedConstants.PARAM_PAGE, description = PaginatedConstants.PARAM_PAGE_DESC, example = PaginatedConstants.PARAM_PAGE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SIZE, description = PaginatedConstants.PARAM_SIZE_DESC, example = PaginatedConstants.PARAM_SIZE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SORT, description = PaginatedConstants.PARAM_SORT_DESC,
                    array = @ArraySchema(schema = @Schema(type = "string", example = PaginatedConstants.PARAM_SORT_EXAMPLE)))
    })
    public ResponseEntity<PaginatedResponse<SupplyDTO>> getSuppliesByUserId(
            @PathVariable String userId,
            @Parameter(hidden = true) @RequestParam @ValidPageableRequest(target = Supply.class) @Valid
            MultiValueMap<String, String> queryParams
    ) {
        PaginatedResponse<SupplyDTO> supplies = supplyHandler.getSuppliesBySuppliedById(userId, queryParams);
        return ResponseEntity.ok(supplies);
    }

}
