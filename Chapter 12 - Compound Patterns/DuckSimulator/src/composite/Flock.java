package composite;

import java.util.ArrayList;
import java.util.Iterator;

import ducks.Quackable;
import observer.Observer;

public class Flock implements Quackable {
    ArrayList<Quackable> quackers = new ArrayList<Quackable>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
            quacker.notifyObservers();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        System.out.println("\n\nCall flock register Obs");
        Iterator<Quackable> iterator = quackers.iterator();
        System.out.println("\nNew Iterator");
        while(iterator.hasNext()) {
            Quackable quacker = iterator.next();
            System.out.println("Register: " + quacker.toString());            
            quacker.registerObserver(observer);
        }
        System.out.println("Iterator exhausted");
    }

    @Override
    public void notifyObservers() { }
}
