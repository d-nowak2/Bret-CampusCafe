package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;


public class LineItem {
    private Product product;
    private BigDecimal quantity;

    public LineItem(Product product, BigDecimal quantity){
        setProduct(product);
        setQuantity(quantity);
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    public BigDecimal getLinePrice(){
        return product.price().multiply(quantity);
    }

    public Product getProduct(){
        return product;
    }
    public BigDecimal getQuantity(){
        return quantity;
    }

}
