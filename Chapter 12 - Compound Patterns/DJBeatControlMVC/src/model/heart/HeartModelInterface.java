package model.heart;

import view.BPMObserver;
import view.BeatObserver;

public interface HeartModelInterface {
    int getHeartRate();
    void registerObserver(BeatObserver beatObserver);
    void removeObserver(BeatObserver beatObserver);
    void registerObserver(BPMObserver bpmObserver);
    void removeObserver(BPMObserver bpmObserver);
}
