public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public int getSize() {
        return beverage.getSize();
    }

    // @Override
    // public String getDescription() {
    //     return beverage.getDescription() + ", Soy";
    // }
    
    @Override
    public String getDescription() {
        String description = beverage.getDescription() + ", Soy ";
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
            cost += .10;
        } else if (getSize() == Beverage.GRANDE) {
            cost += .15;
        } else if (getSize() == Beverage.VENTI) {
            cost += .20;
        }
        return cost;
    }
}
