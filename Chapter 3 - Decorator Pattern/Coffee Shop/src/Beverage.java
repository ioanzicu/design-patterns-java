public abstract class Beverage {
    public static final int TALL = 1;
    public static final int GRANDE = 2;
    public static final int VENTI = 3;
    
    String description = "Unknown Beverage";
    int size = 1;


    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public void setSize(int size) {
        this.size = size;
    };

    public int getSize() {
        return this.size;
    } 
}
