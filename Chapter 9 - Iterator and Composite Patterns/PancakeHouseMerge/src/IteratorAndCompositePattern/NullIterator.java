package IteratorAndCompositePattern;
import java.util.Iterator;

public class NullIterator implements Iterator<Object> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
