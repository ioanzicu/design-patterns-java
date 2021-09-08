public class Mocha extends CondimentDecorator {

    Beverage beverage;
    
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getSize() {
        return beverage.getSize();
    }

    // @Override
    // public String getDescription() {
    //     return beverage.getDescription() + ", Mocha";
    // }

    @Override
    public String getDescription() {
        String description = beverage.getDescription() + ", Mocha ";
        if (getSize() == Beverage.TALL) {
            description += "TALL";
        } else if (getSize() == Beverage.GRANDE) {
            description += "GRANDE";
        } else if (getSize() == Beverage.VENTI) {
            description += "VENTI";
        }
        return description;
    }

    public double cost() {
        double cost = beverage.cost();
        if (getSize() == Beverage.TALL) {
            cost += .20;
        } else if (getSize() == Beverage.GRANDE) {
            cost += .25;
        } else if (getSize() == Beverage.VENTI) {
            cost += .30;
        }
        return cost;
    }
}
