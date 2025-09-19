package edu.lewisuniversity.cafe.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<LineItem> orderList = new ArrayList<>();
    private BigDecimal subTotal = new BigDecimal(0);
    private BigDecimal tax = new BigDecimal(0);
    private BigDecimal taxPercent = new BigDecimal("0.1025");

    public Order(){

    }
    public void addToOrder(LineItem item){
        orderList.add(item);
    }
    public void addToSubTotal(){
        for(LineItem item : orderList){
            subTotal = subTotal.add(item.getLinePrice());
        }
    }
    public BigDecimal getSubTotal(){
        return subTotal;
    }
    public BigDecimal getTax(){
        tax = getSubTotal().multiply(taxPercent);
        return tax;
    }
    public BigDecimal getTotalPrice(){
        return getTax().add(getSubTotal());
    }

    public void printListOfItems(){
        for (LineItem item : orderList)
            System.out.println(item.getProduct().getName() +" x "+ item.getQuantity());
    }
    public void printTotals(Order order){
        System.out.println("Subtotal: " + "$"+ order.getSubTotal().setScale(2, RoundingMode.HALF_UP));
        System.out.println("Tax: " + "$"+order.getTax().setScale(2,RoundingMode.HALF_UP));
        System.out.println("Total Price: " + "$"+order.getTotalPrice().setScale(2,RoundingMode.HALF_UP));
    }

}
