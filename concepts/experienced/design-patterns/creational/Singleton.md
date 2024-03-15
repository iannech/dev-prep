# Singleton Design Pattern
Singleton is a design pattern that ensures on a single instance of a class exists throughout the application and provides a global access of that instance.
- Useful in situations where multiple instances of a class are undesirable or a single point of control and co-ordination is required.

## When should we use Singleton Design Pattern?
1. Single instance Requirement - we need to ensure that there's only one instance of a class throughout the entire application. Useful in scenarios where multiple instances could lead to conflicts or inconsistencies.
2. Global Access - we want a single point of access to the instance, allowing other parts of the application to easily use and interact with it. Eliminates the need to pass instances between objects or managing complex dependencies.
3. Limited Resource Usage - the class represents a limited or expensive resource such as a database connection, file system, or hardware device, and we want to share that resource efficiently among multiple parts of the application.
4. Coordination and Control - we need a centralized point of coordination or control where changes made to the instance can be observed or managed by other parts of the application.

## How does Singleton Design Pattern work?
- The implementation of a **Singleton** class typically employs a *private* Constructor which prevents direct instantiation of the class from outside its own implementation.
- It also has a private static member variable that stores a single instance of itself. Typically name **_instance**, the variable has a default value of NULL.
- This variable's value can be accessed through a *public* static method, typically named **GetInstance()** or **Instance()** which is responsible for instantiating or returning that single instance of the class when required.
- When **GetInstance()** is invoked, it checks **_instance** static member variable to determine if it's NULL(meaning no instance of the class has been instantiated yet) and proceed to create and assign a new instance of the class to **_instance**.
- All subsequent calls to **GetInstance()** method return the same instance.

![alt text](/images/singleton-1.png)
A LoadBalancer use-case
![alt text](/images/singleton-2-1.png)

## Advantages of Singleton Design Pattern
1. Single instance - The singleton pattern guarantees that a class has only one instance throughout the application. Can be useful when managing shared resources or configurations.
2. Global Access - Since singleton instance is globally accessible, it is possible to access its methods and properties from anywhere in the app, eliminating the need to pass objects' instances or manage complex dependencies.
3. Lazy Initialization - Singleton pattern supports lazy initialization, meaning the instance is only created at the time of accessing it for the first time. This can improve performance by deffering instantiation until it's required.
4. Thread safety - Singleton pattern can be made thread-safe, allowing multiple threads to access the instance without causing concurrency issues(critical in mult-threaded applications)

## Disadvantages of Singleton Design Pattern
1. Global State - The pattern introduces a global state, which can make it harder to track and reason about the behavior of a system. Changes to the Singleton instance can affect other parts of the app, resulting in hidden bugs and unintended side effects.
2. Tight Coupling - Since the singleton instance is directly accessed throughout the application, it can lead to coupling issues between classes making it more difficult to modify or replace the Singleton in the future with a different implementation.
3. Testing Challenges - Using Singletons can make Unit testing more difficult. Since Singleton instance is globally accessible, it can be challenging to isolate and test dependent components. Mocking or substituting the Singleton instance during testing might require additional work/code change.
4. Difficulty in Lifecycle Management - Typically, Singletons have a long lifetime, existing for the duration of the application. Managing the lifecycle of a Singleton such as releasing resources or resetting the state can be complicated, especially in cases where the instance must be re-initialized.
5. Limited Extensibility - Due to their restricted instantiation and global access, it can be difficult to extend or modify Singleton classes. Introducing new variations or behaviors to the Singleton without modifying the existing implementation can be challenging too.
6. Violates the Single Responsibility Principle - The principle states that each class should have a single task to do, but in the case of Singleton class, it has 2 responsibilities, one to create an instance and the other to do the actual task.
7. Breaks the Open-Closed Principle - Simple definition of the Principle = "Open for Extension, Closed for Modification". The Singleton class always returns its own instance and is Never open for extension.

## Real-world examples of Singleton Design Pattern
- Logger: In many software systems, logging is an essential component for recording events and debugging purposes. A Logger class can manage logging operations throughout the application. It ensures that only one instance of the Logger exists, and all parts of the system can access it easily.
- Database Connection: When an application needs to connect to a database, it is often beneficial to have a single, shared connection that multiple components can utilize. A DatabaseConnection class can be implemented to provide a centralized point for establishing and managing the database connection.
- Configuration Manager: Applications often require a centralized configuration to store settings and properties. The Singleton pattern can be used to create a ConfigurationManager class that loads and manages the application configuration. This ensures that all parts of the application access the same configuration data.
- Cache Manager: Caching is a common technique used to improve performance by storing frequently accessed data in memory. A CacheManager class can be employed to handle caching operations across the application, ensuring that only one cache instance exists and is accessible from multiple components.
- Thread Pool: In concurrent programming, a thread pool is a common design pattern where a pool of threads is created to execute tasks. A ThreadPool class can be implemented as a Singleton to manage the creation, allocation, and execution of threads, providing a shared resource for handling concurrent tasks.