package model.beat;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import view.BPMObserver;
import view.BeatObserver;

public class BeatModel  implements BeatModelInterface, MetaEventListener {
    // MetaEventListener - needed for the MIDI code
    Sequencer sequencer; // object that knows how to generate real beat
    ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
    int bpm = 90; // beat per minute
    Sequence sequence;
    Track track;

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        // System.out.println("Print " + bpm);
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    void beatEvent() {
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    public void notifyBeatObservers() {
        Iterator<BeatObserver> iterator = (Iterator<BeatObserver>) beatObservers.iterator();
        while(iterator.hasNext()) {
            BeatObserver observer = (BeatObserver) iterator.next();
            observer.updateBeat();
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        int i = beatObservers.indexOf(observer);
        if (i >= 0) {
            beatObservers.remove(i);
        }        
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    public void notifyBPMObservers() {
        Iterator<BPMObserver> iterator = (Iterator<BPMObserver>) bpmObservers.iterator();
        while(iterator.hasNext()) {
            BPMObserver observer = (BPMObserver) iterator.next();
            observer.updateBPM();
        }
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        int i = bpmObservers.indexOf(observer);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }
    
    public void meta(MetaMessage message) {
        if (message.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
