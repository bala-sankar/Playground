# Data Structures

## Stack


# Design Patterns

Strategy - defines a family of algorithms encapsulates each one , and makes them interchangable. Strategy lets the
    algorithm vary independently from clients that we use it.

Observer - defines one-to-many dependency between objects  so that when one object changes state, all of its dependents
    are notified  and updated automatically.

Decorator - attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to
    subclassing for extending functionality.

Factory Method - defines an interface for creating an object, but lets subclasses decide which class to
    instantiate. Factory Method lets a class defer instantiation to subclasses.

Abstract Factory - provides an interface for creating families of related or dependent objects without specifying
    their concrete classes.

Singleton - ensures a class has only one instance, and provides a global point of access to it.

# Design Principle

* Program to an interface, not an implementation
* Favor composition over inheritance
* Encapsulate what varies
* Strive for loosely coupled designs between objects that interact
* Classes should be open for extension, but closed for modification
* Depend upon abstractions. Do not depend upon concrete classes.
* To follow Dependency Inversion Principle
    - No variable should hold a reference to a concrete class.
    - No class should derive from a concrete class.
    - No method should override an implemented method of any of its base classes.