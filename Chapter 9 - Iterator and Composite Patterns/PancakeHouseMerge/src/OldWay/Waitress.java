package OldWay;
import java.util.ArrayList;

public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    ArrayList<MenuItem> breakfastItems;

    DinerMenu dinerMenu;
    MenuItem[] lunchItems;

    public Waitress() {
        pancakeHouseMenu = new PancakeHouseMenu();
        breakfastItems = pancakeHouseMenu.getMenuItems();

        dinerMenu = new DinerMenu();
        lunchItems = dinerMenu.getMenuItems();
    }

    public void printMenu() {

        System.out.print("MENU\n----\nBREAKFAST");
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
        
        System.out.println("\nLUNCH");
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem != null) {
                System.out.print(menuItem.getName() + " ");
                System.out.println(menuItem.getPrice() + " ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public void printBreakfastMenu() {
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printLunchMenu() {
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printVegetarianMenu() {
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + " ");
                System.out.println(menuItem.getPrice() + " ");
                System.out.println(menuItem.getDescription());
            }
        }

        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + " ");
                System.out.println(menuItem.getPrice() + " ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public void isItemVegetarian() {

    }
}
