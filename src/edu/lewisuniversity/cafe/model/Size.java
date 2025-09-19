package edu.lewisuniversity.cafe.model;
import java.math.BigDecimal;


//as I was uploading this I realized for some reason I made the sizes multiplicative instead of additive, I will change that
public enum Size {
    SMALL(BigDecimal.valueOf(1.0)),
    MEDIUM(BigDecimal.valueOf(1.25)),
    LARGE(BigDecimal.valueOf(1.5));

    private final BigDecimal multiplier;

    Size(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}