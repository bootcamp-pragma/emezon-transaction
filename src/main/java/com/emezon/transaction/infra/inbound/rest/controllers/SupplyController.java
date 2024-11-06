package com.emezon.transaction.infra.inbound.rest.controllers;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.app.handlers.ISupplyHandler;
import com.emezon.transaction.app.mappers.SupplyMapper;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.infra.inbound.rest.constants.RestApiConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(RestApiConstants.API_SUPPLY)
@RequiredArgsConstructor
public class SupplyController {

    private final ISupplyHandler supplyHandler;

    @PostMapping
    public ResponseEntity<SupplyDTO> createSupply(@RequestBody @Valid CreateSupplyDTO createSupplyDTO) {
        SupplyDTO supplyDTO = supplyHandler.createSupply(createSupplyDTO);
        URI location = URI.create(RestApiConstants.API_SUPPLY);
        return ResponseEntity.created(location).body(supplyDTO);
    }

}
