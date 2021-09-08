package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
    private static void main(String args[]) {
        ArrayList arrayList = new ArrayList<Car>();
        Car car1 = new Car("1");
        Car car2 = new Car("2");

        arrayList.add(car1);
        arrayList.add(car2);

        System.out.println("Test Iterator interface");
        System.out.println("hasNext(): " + ((Iterator) arrayList).hasNext());
        System.out.println("next(): " + ((Iterator) arrayList).next());
    }
}