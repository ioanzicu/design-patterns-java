import java.util.ArrayList;
// import java.util.Enumeration;
import java.util.Iterator;
import test.Enumeration;

import test.Car;
import test.IteratorEnumeration;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> arrayList = new ArrayList<Car>();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");
        Car car5 = new Car("5");

        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);
        arrayList.add(car4);
        arrayList.add(car5);

        System.out.println("Test Iterator interface");
        Iterator<Car> iter = arrayList.iterator();
        System.out.println("hasNext(): " + iter.hasNext());
        System.out.println("next(): " + iter.next());
        System.out.println("next(): " + iter.next());
        
        System.out.println("Test Enumeration interface or IteratorEnumeration adapter");
        System.out.println("Calling hasMoreElements and hasNext on Iterator as I would do it on an Enumeration");
        Enumeration enumeration = new IteratorEnumeration(iter);
        System.out.println("hasMoreElements(): " + enumeration.hasMoreElements());
        System.out.println("hasNext(): " + enumeration.nextElement());
        System.out.println("hasNext(): " + enumeration.nextElement());
        
        
    }
}