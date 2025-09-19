package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public class Food extends Product{

    private AddOn addon;

    public Food(String id, String name, BigDecimal basePrice, AddOn addon) {
        super(id, name, basePrice);
        setAddon(addon);
    }

    public void setAddon(AddOn addon){
        this.addon = addon;
    }

    @Override
    public BigDecimal price() {
        return getBasePrice().add(addon.getSurcharge());
    }
}