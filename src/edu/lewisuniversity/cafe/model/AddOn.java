package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public enum AddOn {
    TOASTED(BigDecimal.valueOf(1.00)),
    CRACKERS(BigDecimal.valueOf(1.00)),
    NO_ADDON(BigDecimal.valueOf(0.00));

    private final BigDecimal surcharge;

    AddOn(BigDecimal surcharge){
        this.surcharge = surcharge;
    }

    public BigDecimal getSurcharge(){
        return surcharge;
    }
}
