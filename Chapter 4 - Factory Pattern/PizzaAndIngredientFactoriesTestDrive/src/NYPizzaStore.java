import ingredients.PizzaIngredientFactory;
import ingredients.NYPizzaIngredientFactory;


public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        String pizzaStyle = "New York";

        if (item.equals("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName(pizzaStyle + " Style Cheese Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName(pizzaStyle + " Style Clam Pizza");

        }
        return pizza;
    }
}
