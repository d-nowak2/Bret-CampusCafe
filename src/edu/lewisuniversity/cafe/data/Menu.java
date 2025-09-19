package edu.lewisuniversity.cafe.data;
import edu.lewisuniversity.cafe.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Menu {
    private final ArrayList<Product> menuItems = new ArrayList<>();
    Food sandwich = new Food("F01", "Sandwich", new BigDecimal("5.25"), AddOn.NO_ADDON);
    Food soup = new Food("F02", "Soup", new BigDecimal("4.50"),AddOn.NO_ADDON);
    Beverage lemonade = new Beverage("B01", "Lemonade", new BigDecimal("3.00"), Size.SMALL);
    Beverage drPepper = new Beverage("B02", "Dr. Pepper", new BigDecimal("2.00"),Size.SMALL);
    public Menu() {
        menuItems.add(sandwich);
        menuItems.add(soup);
        menuItems.add(lemonade);
        menuItems.add(drPepper);
    }
    public void printMenu() {
        for (Product item : menuItems) {
            System.out.println(item.getName() + " " + "(" + item.getId() + ")" + " " + "$" + item.getBasePrice());
        }
    }

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
    }

}