package receivers;

public class Light {
    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(name + " - Light ON");
    }

    public void off() {
        System.out.println(name + " - Light OFF");
    }
}
