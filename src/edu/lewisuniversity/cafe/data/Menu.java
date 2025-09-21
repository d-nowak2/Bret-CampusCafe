package edu.lewisuniversity.cafe.data;

import edu.lewisuniversity.cafe.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Menu {
    private final ArrayList<Product> menuItems = new ArrayList<>();
    
    public Menu() {
        Food food = new Food("F01", "Sandwich", new BigDecimal("5.25"));
        menuItems.add(food);
        food = new Food("F02", "Soup", new BigDecimal("4.50"));
        menuItems.add(food);
        
        Beverage bev = new Beverage("B01", "Lemonade", new BigDecimal("3.00"));
        menuItems.add(bev);
        bev = new Beverage("B02", "Dr. Pepper", new BigDecimal("2.00"));
        menuItems.add(bev);
        
        /*
        menuItems.add(sandwich);
        menuItems.add(soup);
        menuItems.add(lemonade);
        menuItems.add(drPepper);*/
    }
    public void printMenu() {
        for (Product item : menuItems) {
        	System.out.println(String.format("%s (%s) $%.2f", 
        			item.getName(), item.getId(), item.getBasePrice()));
            //System.out.println(item.getName() + " " + "(" + item.getId() + ")" + " " + "$" + item.getBasePrice());
        }
    }

    public Product getOrder(String input) throws Exception {
    	for(Product item : menuItems) {
    		if(item.getId().equalsIgnoreCase(input)) {
    			return item;
    		}
    	}
    	
    	return null;
    }
    
    /*
    public Food getOrderedFood(String input) throws Exception{
        if (input.equals("F01"))
            return sandwich;
        else if (input.equals("F02"))
            return soup;
        else throw new Exception("Please enter valid id");
    }
    public Beverage getOrderedBev(String input) throws Exception{
        if (input.equals("B01"))
            return lemonade;
        else if(input.equals("B02"))
            return drPepper;
        else throw new Exception("Please enter valid id");
    }*/

}