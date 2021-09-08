package IteratorWayImproved;
import java.util.Iterator;

public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator<Object> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<Object> dinerIterator = dinerMenu.createIterator();
        System.out.print("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator<Object> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {
        Iterator<Object> pancakeIterator = pancakeHouseMenu.createIterator();
        System.out.print("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
    }

    public void printLunchMenu() {
        Iterator<Object> dinerIterator = dinerMenu.createIterator();
        System.out.println("MENU\n----\nLUNCH");
        printMenu(dinerIterator);
    }

    public void printVegetarianMenu() {
        Iterator<Object> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<Object> dinerIterator = dinerMenu.createIterator();
        System.out.print("MENU\n----\nBREAKFAST");
        printVegetarianMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printVegetarianMenu(dinerIterator);
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
