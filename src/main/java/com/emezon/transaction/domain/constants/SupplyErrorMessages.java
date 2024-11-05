package com.emezon.transaction.domain.constants;

public class SupplyErrorMessages {

    public static final String SUPPLY_QUANTITY_MIN_VALUE = "The quantity of the supply must be greater than 0";
    public static final String SUPPLY_COST_MIN_VALUE = "The cost of the supply must be greater than or equal to 0";
    public static final String SUPPLY_COMMENTS_MAX_LENGTH = "The comments of the supply must have a maximum of 255 characters";

    private SupplyErrorMessages() { }

}
