package IteratorAndCompositePattern;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    Stack<Object> stack = new Stack<Object>();

    public CompositeIterator(Iterator<Object> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<Object> iterator = (Iterator<Object>) stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator<Object> iterator = (Iterator<Object>) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
