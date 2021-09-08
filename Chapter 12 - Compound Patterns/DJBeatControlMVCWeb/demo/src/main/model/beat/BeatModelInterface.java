package model.beat;

public interface BeatModelInterface {
    // Methods used by the CONTROLLER to direct model
    // based on the user interaction
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);

    // Methods that allow the VIEW and the controller
    // to get state and to become observers
    int getBPM();
}
