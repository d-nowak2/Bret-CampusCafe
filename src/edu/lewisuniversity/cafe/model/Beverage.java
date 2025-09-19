package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public class Beverage extends Product {

    private Size size;

    public Beverage(String id, String name, BigDecimal basePrice, Size size) {
        super(id, name, basePrice);
        setSize(size);

    }

    public void setSize(Size size){
        this.size = size;
    }

    @Override
    public BigDecimal price() {
        return getBasePrice().multiply(size.getMultiplier());
    }
}
