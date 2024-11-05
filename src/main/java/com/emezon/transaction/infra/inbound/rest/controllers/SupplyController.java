package com.emezon.transaction.infra.inbound.rest.controllers;

import com.emezon.transaction.infra.inbound.rest.constants.RestApiConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiConstants.API_SUPPLY)
public class SupplyController {

    @GetMapping("/test")
    public String test() {
        return "SupplyController test";
    }

}
