package caffeine_beverages_redesigned;

public abstract class CaffeineBeverage {
    
    // FINAL - the subclasses will not be able to overwrite it
    final void prepareRecipe() {
        boiledWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boiledWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
