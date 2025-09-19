package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;

public abstract class Product {
    private String id;
    private String name;
    private BigDecimal basePrice;

    public Product(String id, String name, BigDecimal basePrice){
        setId(id);
        setName(name);
        setBasePrice(basePrice);
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getBasePrice(){
        return basePrice;
    }

    public void setId(String id){this.id = id;}
    public void setName(String name){
        this.name = name;
    }
    public void setBasePrice(BigDecimal basePrice){
        this.basePrice = basePrice;
    }

    public abstract BigDecimal price();
}