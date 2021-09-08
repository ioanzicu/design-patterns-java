package IteratorWayImprovedMergedCafe;
import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    ArrayList<Object> menus;

    public Waitress(ArrayList<Object> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        Iterator<Object> menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator<Object> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {}

    public void printLunchMenu() {}

    public void printVegetarianMenu() {
        Iterator<Object> menuIterator = menus.iterator();
        while(menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printVegetarianMenu(menu.createIterator());
        }
    }

    private void printVegetarianMenu(Iterator<Object> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public void isItemVegetarian() {}
}
