package IteratorAndCompositePattern;

public class MenuTestDrive {
    public static void main(String args[]) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem(
            "Moldovian Pancake Classic", 
            "Pancakes with scrumbled eggs, toast, and sweet whipped milk cream", 
            false, 
            4.99));

        pancakeHouseMenu.add(new MenuItem(
            "Moldovian Pancake Regular", 
            "Pancakes with scrumbled eggs, toast", 
            false, 
            4.49));

        pancakeHouseMenu.add(new MenuItem(
            "Strawberry Pancake", 
            "Pancakes with fresh strawberries ", 
            true, 
            3.99));

        pancakeHouseMenu.add(new MenuItem(
            "Waffles", 
            "Waffles, with blueberries", 
            true, 
            3.49));


        dinerMenu.add(new MenuItem(
            "Vegetarian BLT",
            "Vegetarian Bacon with lettuce and tomato on whole wheat", 
            true,
            3.49));

        dinerMenu.add(new MenuItem(
            "BLT",
            "Bacon with lettuce and tomato on whole wheat", 
            false,
            4.49));

        dinerMenu.add(new MenuItem(
            "Soup of the day",
            "Soup of the day, with a side of potato salad", 
            false,
            3.99));

        dinerMenu.add(new MenuItem(
            "Hotdog",
            "A hot dog, with saurkraut, relish, onions, topped with cheese", 
            false,
            3.49));

        dinerMenu.add(new MenuItem(
            "Pasta", 
            "Spaghetti with Marinara Sauce, and a slice of sourdough bread", 
            true, 
            3.89));

        cafeMenu.add(new MenuItem(
            "Veggie Pierogi", 
            "Veggie Pierogi with potatos and tomatoes",
            true,
            3.99));

        cafeMenu.add(new MenuItem(
            "Soup of the day", 
            "A cup of the soup of the day, with a side salad",
            false,
            3.69));
        
        cafeMenu.add(new MenuItem(
            "Burrito", 
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true,
            4.29));

        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem(
            "Apple Pie", 
            "Apple pie with a flakey crust, topped with vanilla icecream", 
            true, 
            1.59));

        dessertMenu.add(new MenuItem(
            "Cheesecake", 
            "Creamy Wrocław cheesecake, with a chocolate graham crust", 
            true, 
            2.29));

        Waitress waitress = new Waitress(allMenus);
        // waitress.printMenu();
        waitress.printVegetarianMenu();
    }
    

    // public void testCompositeIterator(MenuComponent component) {
    //     CompositeIterator iterator = new CompositeIterator(component.iterator);

    //     while (iterator.hasNext()) {
    //         MenuComponent nextComponent = iterator.next();
    //     }
    // }
}
