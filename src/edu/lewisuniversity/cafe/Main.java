package edu.lewisuniversity.cafe;

import edu.lewisuniversity.cafe.data.Menu;
import edu.lewisuniversity.cafe.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        Product item = null;

        do {
            try {
                menu.printMenu();
                System.out.print("\nEnter Item Id or 'DONE' to exit: ");
                String userOrder;
                userOrder = scan.nextLine();
                if (userOrder.equalsIgnoreCase("DONE")){
                    break;
                }
                else {
                	item = menu.getOrder(userOrder);
                	if(item instanceof Food) {processFoodOrder(item);}
                	else if(item instanceof Beverage) {processDrinkOrder(item);}
                	else { 
                		System.out.println("\nInvalid Selection\n");
                		continue;
                	}
                }
                /*
                else if (userOrder.startsWith("F")){
                    item = menu.getOrderedFood(userOrder);
                    processFoodOrder((Food)item);
                }

                else if (userOrder.startsWith("B")){
                    item = menu.getOrderedBev(userOrder);
                    processDrinkOrder((Beverage)item);
                }*/

                System.out.print("\nHow many: ");
                String quantity = scan.nextLine();

                LineItem firstLine = new LineItem(item, new BigDecimal(quantity));
                order.addToOrder(firstLine);
                order.addToSubTotal();

            } catch (Exception exception) {
                System.out.println("\n"+exception.getMessage()+"\n");
            }
        } while (true);
        order.printListOfItems();
        order.printTotals(order);
    }
    //move this into food?
    private static void processFoodOrder(Product item) {
        if(item.getName().equals("Sandwich")){
            System.out.print("\nWould you like that toasted for $1.00? [Y/N] ");
	        String extraCharge = scan.nextLine();
	        if(extraCharge.equalsIgnoreCase("Y")){
	            ((Food) item).setAddon(AddOn.TOASTED);}
	        else if(extraCharge.equalsIgnoreCase("N")) {
	            ((Food) item).setAddon(AddOn.NO_ADDON);}
	        else {throw new RuntimeException("Please enter Y/N");}
    }
        if(item.getName().equals("Soup")){
            System.out.print("\nWould you like crackers with that for $1? [Y/N]");
            String extraCharge = scan.nextLine();
            if(extraCharge.equalsIgnoreCase("Y")){
                ((Food) item).setAddon(AddOn.CRACKERS);
            }else if(extraCharge.equalsIgnoreCase("N")){
                ((Food) item).setAddon(AddOn.NO_ADDON);
            }
            else throw new RuntimeException("Please enter Y/N");
        }
    }
    //move this into beverage?
    private static void processDrinkOrder(Product item){
        System.out.print("\nWhat size would you like [S/M/L]?");
        String extraCharge = scan.nextLine();
        if (extraCharge.equalsIgnoreCase("S")){
            ((Beverage) item).setSize(Size.SMALL);}
        else if(extraCharge.equalsIgnoreCase("M")){
            ((Beverage) item).setSize(Size.MEDIUM);}
        else if (extraCharge.equalsIgnoreCase("L")){
            ((Beverage) item).setSize(Size.LARGE);
        }else throw new RuntimeException("Please enter a size");
    }

}