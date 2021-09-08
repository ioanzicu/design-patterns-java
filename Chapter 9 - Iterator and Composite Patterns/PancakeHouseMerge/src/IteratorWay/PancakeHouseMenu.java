package IteratorWay;
import java.util.ArrayList;

public class PancakeHouseMenu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();

        addItem("Moldovian Pancake Classic", 
                "Pancakes with scrumbled eggs, toast, and sweet whipped milk cream", 
                false, 
                4.99);

        addItem("Moldovian Pancake Regular", 
                "Pancakes with scrumbled eggs, toast", 
                false, 
                4.49);

        addItem("Strawberry Pancake", 
                "Pancakes with fresh strawberries ", 
                true, 
                3.99);

        addItem("Waffles", 
                "Waffles, with blueberries", 
                true, 
                3.49);
    }

    public void addItem(String name, 
                        String description,
                        boolean vegetarian, 
                        double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);        
    }

    // a lot of other code 
}