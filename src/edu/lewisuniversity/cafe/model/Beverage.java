package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public class Beverage extends Product {
    private Size size;

    public Beverage(String id, String name, BigDecimal basePrice) {
        super(id, name, basePrice);
    }

    public void setSize(Size size){
        this.size = size;
    }

    @Override
    public BigDecimal price() {
        return this.getBasePrice().multiply(size.getMultiplier());
    }
}
