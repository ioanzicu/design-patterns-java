package receivers;

public class Stereo {
    String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " - Stereo is ON");
    }

    public void off() {
        System.out.println(name + " - Stereo is OFF");
    }

    public void setCd() {
        System.out.println(name + " - Stereo set CD");
    }

    public void setDvd() {
        System.out.println(name + " - Stereo set DVD");
    }

    public void setRadio() {
        System.out.println(name + " - Stereo set RADIO");
    }

    public void setVolume(int volume) {
        System.out.println(name + " - Stereo set VOLUME " + volume);
    }
}
