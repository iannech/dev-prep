# Factory Method Design Pattern
- Is an OOP design pattern that allows us to create objects without specifying the exact class that will be instantiated.
- Instead of creating objects directly, we use a factory method to create and return them.

## When to use the Factory Method pattern?
1. When we don't know the exact class of objects that will be created at runtime.
2. We want to encapsulate the object creation process.
3. We want to promote loose coupling between classe.
4. We want to promote code reuse.


## How does the Factory Method creational pattern work?
Factory Method pattern consists of 4 main components:
1. **Product** - is the interface or abstract class that defines the methods that the **ConcreteProduct** must implement.
2. **ConcreteProduct** - is the class that implements the **Product** Interface.
3. **Creator** - is the abstract class that declares the **FactoryMethod**. 
4. **ConcreteCreator** - is the class that implements the **FactoryMethod** and returns **ConcreteProduct**.

![Factory Method](/images/image.png)

## An example of Factory Method project implementation

Let use a Furniture Shop Application example.

- The furniture shop is capable of producing furniture sets in different variants, like; **Modern, Classic and Retro** with different products like Armchairs, Sofas and Coffee tables being available for each variant.
- For each variant, we have a **ConcreteFactory** class like **RetroFurnitureFactory**. This is responsible for creating a **RetroArmchair, RetroCoffeeTable, RetroSofa** products using the **MakeArmchair()**, **MakeCoffeeTable()** and **MakeSofa()** methods.
- In this case, the **RetroFurnitureFactory** is a **ConcreteCreator** that creates products using specific **Factory Methods**.
- The Abstract **Creator** is, in our example, the **FurnitureFactory** abstract class, and the abstract **Product** is at the very bottom of the inheritance hierarchy, the **Product** abstract class.

![Illustration of above scenario](/images/factory-method-2.webp)


## Advantages of the Factory Method Design Pattern
1. Loose coupling - This design pattern promotes loose coupling between classes. The Creator class doesn't need to know the exact class that willbe instantiated. This makes the code more modular and easy to maintain.
2. Encapsulation - This pattern encapsulates the object creation process without affecting the rest of the code.
3. Code reuse - Promotes code reuse by allowing multiple classes to share a common interface.
4. Extensibility - This pattern is extensible. It allows new **ConcreteProduct** classes to be added without modifying existing code.

## Disadvantages of the Factory Method Design Pattern
1. Complexity - This design patter can add complexity to the code. Requires creation of additional classes and interfaces.
2. Overhead - The pattern can introduce additional overhead into the application. This can result in decreased performance if the creation of objects is a performance bottleneck.


## Differences between Factory Method and Abstract Factory
- Both are Creational design patterns in OOP and while they share similarities like encapsulating object creation by delegating it to subclasses, they also have specific use cases.
- Main difference is in their level of abstraction and the way they create objects.
- The Factory Method pattern defines an interface for creating objects, but it allows subclasses to decide which classes to instantiate. It encapsulates the object creation logic in a separate method, which can be overridden by subclasses to create different types of objects. This pattern is useful when we want to create objects that belong to a single family of class and defer instantiation to their subclasses.
- On the other hand, Abstract Factory pattern gives us a way to make groups of related or dependent objects without having to specify their concrete classes. It encapsulates a group of factories, each of which creates a family of objects related to each other. 