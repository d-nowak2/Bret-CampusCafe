package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public class Food extends Product{
    private AddOn addon;

    public Food(String id, String name, BigDecimal basePrice) {
        super(id, name, basePrice);
    }

    public void setAddon(AddOn addon){
        this.addon = addon;
    }

    @Override
    public BigDecimal price() {
        return getBasePrice().add(addon.getSurcharge());
    }
}