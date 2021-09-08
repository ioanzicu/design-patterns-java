package receivers;
public class GarageDoor {
    String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void up() {
        System.out.println("Door is OPEN");
    }

    public void down() {
        System.out.println("Door is CLOSED");
    }

    public void stop() {
        System.out.println("Door is STOPPED");
    }

    public void lightOn() {
        System.out.println("Door Light ON");
    }

    public void lightOff() {
        System.out.println("Door Light OFF");
    }
}
