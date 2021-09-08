package model.heart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import view.BPMObserver;
import view.BeatObserver;

public class HeartModel implements HeartModelInterface, Runnable {
    ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int lastRate = -1;

        for (;;) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (rate < 120 && rate > 50) {
                time += change;
            }
            notifyBeatObservers();
            if (rate != lastRate) {
                lastRate = rate;
                notifyBPMObservers();
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) { }
        }
    }

    @Override
    public int getHeartRate() {
        return 60000 / time;
    }

    @Override
    public void registerObserver(BeatObserver beatObserver) {
        beatObservers.add(beatObserver);
    }

    @Override
    public void removeObserver(BeatObserver beatObserver) {
        int i = beatObservers.indexOf(beatObserver);
        if (i >= 0) { 
            beatObservers.remove(i);
        }
    }

    public void notifyBeatObservers() {
        Iterator<BeatObserver> iterator = (Iterator<BeatObserver>) beatObservers.iterator();
        while (iterator.hasNext()) {
            BeatObserver beatObserver = (BeatObserver) iterator.next();
            beatObserver.updateBeat();
        }
    }

    @Override
    public void registerObserver(BPMObserver bpmObserver) {
        bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(BPMObserver bpmObserver) {
        int i = bpmObservers.indexOf(bpmObserver);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }
    
    public void notifyBPMObservers() {
        Iterator<BPMObserver> iterator = (Iterator<BPMObserver>) bpmObservers.iterator();
        while(iterator.hasNext()) {
            BPMObserver bpmObserver = iterator.next();
            bpmObserver.updateBPM();
        }
    }
}
