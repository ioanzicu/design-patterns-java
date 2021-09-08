package caffeine_beverages_with_hook;

public abstract class CaffeineBeverageWithHook {
    
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // HOOK method - can be overriden by the subclass
    boolean customerWantsCondiments() {
        return true;
    }
}
