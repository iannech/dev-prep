# Abstract Factory Design Pattern

- Is a creational design pattern that allows creation of families of related objects without specifying their concrete classes.
- A real example could be applied to a furniture shop application with:
    1. A family of related products including **armchairs**, **sofas**, and **coffee tables**
    2. Several *variants* of this family e.g **Modern**, **Classic**, **Retro**

- On **Client's** request, we need to create individual furniture objects so that they match other objects of the same family. Also, we don't want to change existing code when adding new products to the application.
- The Abstract Factory pattern first suggests explicitly declaring interfaces for each Product in the product family (e.g Armchair, Sofa, CoffeeTable). Then we can make all *variants* of products follow those interfaces e.g All Armchair *variants* can Implement Armchair interface.

![All variants of the same object must be part of a single class hierarchy](/images/abstract-factory.webp)

- Next, we declare the Abstract Factory; this is an interface which lists methods to create the products that are part of the product family e.g (**MakeArmchair**, **MakeSofa**, **MakeCoffeeTable**).
- These methods must return abstract product types represented by the previously extracted interfaces such as Armchair, Sofa, CoffeeTable etc.

![Each concrete factory corresponds to a specific product variant](/images/furniture-factory.webp)

- Now, what about the different product variants? For each variant of a product family, we create a specific factory class based on the **FurnitureFactory** interface. For Example; the **ClassicFurnitureFactory** can only create an **Armchair**, a **CoffeeTable** and **Sofa** objects.
- The **Client's** code will use both factories and products through their abstract interfaces to start making a product that belongs to a certain family, which allows us to change the type of factory that we pass to the **Client's** code, as well as the product variant, without breaking the existing implementation.
- But what creates the factory objects if the Client is only exposed to the abstract interfaces? - Typically, during initialization, the application creates a concrete factory object, which is then passed as an argument to the Client's method that creates Product(s).
- Overall diagram looks like this.

![Overall diagram](/images/classic-furniture-factory.webp)

## Summary
1. Abstract Products declare interfaces for a set of distinct but related products which make up a product family.
2. Concrete Products are various implementations of Abstract Products, grouped by variants. Each Abstract product (armchair, sofa etc) must be implemented in all given variants (Classic, Modern, etc)
3. Abstract Factory interface declares a set of methods for creating each of the Abstract Products
4. Concrete Factories implement the creation methods of the Abstract Factory. Each Concrete Factory corresponds to a specific variant of Products and creates only those product variants.
5. Although Concrete Factories instantiate Concrete Products, signatures of their creation methods must return corresponding Abstract Products. This way the Client’s code that uses a factory doesn’t get coupled to the specific variant of the product it gets from a factory. The Client can work with any concrete factory/product variant, as long as it communicates with their objects via abstract interfaces.

- We should use the Abstract Factory when our code needs to work with different families of related products but we don’t want it to depend on the concrete classes of those products (depend on abstractions rather than implementations; see the Dependency Inversion Principle). 

## Advantages of Abstract Factory Design Pattern
1. The products (objects) that we’re getting from a factory are compatible with each other.
2. Tight coupling between **Concrete Products** and the **Client’s** code is avoided.
3. It is easier to maintain the code because we can extract all of the code required to make products in one place (**Single Responsibility Principle**).
4. We can introduce new product variations without breaking the existing Client’s code (**Open/Closed Principle**).

## Disadvantages of Abstract Factory Design Pattern
1. Introduces a lot of Complexity
