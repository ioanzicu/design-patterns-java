package ducks;

import observer.QuackObservable;

public interface Quackable extends QuackObservable {
    public void quack();
}