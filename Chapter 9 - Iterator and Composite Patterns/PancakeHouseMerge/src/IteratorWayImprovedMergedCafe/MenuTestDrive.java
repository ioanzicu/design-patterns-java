package IteratorWayImprovedMergedCafe;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        ArrayList<Object> menus = new ArrayList<Object>();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();


        System.out.println("\n\n------------");
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem("Pancakes", "delicious pancakes", true, 1.59));
        items.add(new MenuItem("Waffles", "super tasty", true, 1.99));
        items.add(new MenuItem("Toast", "perfect toast", true, 0.59));

        for (MenuItem item: items) {
            System.out.println("Breakfast item: " + item);
        }
    }
}
