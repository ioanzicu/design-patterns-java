# Design Patterns in Java

based on book *"Head First Design Patterns"*
by Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra



## Object Oriented Basics
- Abstraction
- Encapsulation
- Polymorphysm
- Inheritance

## Object Oriented Principles
- Encapsulate what varies.
- Favor composition over inheritence.
- Program to interfaces, not implementations.


## Patterns

1. **Strategy** 

    **The Strategy Pattern** defines a family of algorithms,
    encapsulates each one, and makes them interchangeable.
    Strategy lets the algorithm vary independently from
    clients that use it.

2. **Observer**

    **The Observer Pattern** defines a one-to-many
    dependency between objects so that when one
    object changes state, all of its dependents are
    notified and updated automatically.

3. **Decorator**
    
    **The Decorator Pattern** attaches additional
    responsibilities to an object dynamically.
    Decorators provide a flexible alternative to
    subclassing for extending functionality.

4. **Factory**
    
    **The Factory Method Pattern** defines an interface
    for creating an object, but lets subclasses decide which
    class to instantiate. Factory Method lets a class defer
    instantiation to subclasses.

    **The Abstract Factory Pattern** provides an interface
    for creating families of related or dependent objects
    without specifying their concrete classes.

5. **Singleton**
    
    **The Singleton Pattern** ensures a class has only one
    instance, and provides a global point of access to it.

6. **Command**

    **The Command Pattern** encapsulates a request as an
    object, thereby letting you parameterize other objects
    with different requests, queue or log requests, and support
    undoable operations.

7. **Adapter** and **Facade**

    **The Adapter Pattern** converts the interface of a class
    into another interface the clients expect. Adapter lets
    classes work together that couldn’t otherwise because of
    incompatible interfaces.

    **The Facade Pattern** provides a unified interface to a
    set of interfaces in a subsytem. Facade defi nes a higher-
    level interface that makes the subsystem easier to use.

8. **Template Method**

    **The Template Method Pattern** defines the skeleton
    of an algorithm in a method, deferring some steps to
    subclasses. Template Method lets subclasses redefine
    certain steps of an algorithm without changing the
    algorithm’s structure.

9. **Iterator and Composite**

    **The Iterator Pattern** provides a way to
    access the elements of an aggregate object
    sequentially without exposing its underlying
    representation.

    **The Composite Pattern** allows you to
    compose objects into tree structures to
    represent part-whole hierarchies. Composite
    lets clients treat individual objects and
    compositions of objects uniformly.

10. **State**

    **The State Pattern** allows an object to alter its behavior
    when its internal state changes. The object will appear to
    change its class.

11. **Proxy**

    **The Proxy Pattern** provides a surrogate or
    placeholder for another object to control access to it.

- **A remote proxy** controls access to a remote object.
- **A virtual proxy** controls access to a resource that is expensive to create.
- **A protection proxy** controls access to a resource based on access rights.

12. **Compount Patterns**: **MVC** and **MVC v2**

    **A Compound Pattern** combines two or more patterns into a solution that solves
    a recurring or general problem.




