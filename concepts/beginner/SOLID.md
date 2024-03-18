# SOLID Principles

1. **Single Responsibility**
A class should always have one responsibility and should be only a single reason to change it.
*Bad Implementation*
Below Employee class contains personal details, business logic to perform a few calculations and DB logic to save/update.
Our class is tightly coupled, hard to maintain, multiple reasons to modify this class.
![Bad Implementation Single Responsibility](/images/Single_Resp_Bad_Impl.png)
*Good Implementation*
We can split a single Employee class into multiple classes as per their specific responsibility.
This makes our classes loosely coupled, easy to maintain, and only one single reason to modify.
![Good Implementation Single Responsibility](/images/Single_Resp_Good_Impl.png)

2. **Open Closed**
A class should be Open for Extension but Closed for Modification.
*Bad Implementation*
Below EmployeeSalary class calculates salary based on Employee type: Permanent and Contractual.
Issue: In the future, if a new type (Part-time Employee) comes, then the code needs to be modified to calculate salary based on Employee type.
![Bad Implementation Open-Closed](/images/Open-Closed-Bad-Impl.png)
*Good Implementation*
We can introduce a new Interface *EmployeeSalary* and create two child classes for Permanent and Contractual Employees. By doing this, when a new type comes then a new child class needs to be created and our core logic will not change.
![Good Implementation Open-Closed](/images/Open-Closed-Good-Impl.png)

3. **Liskov Substitution**
Child classes should be replaceable with Parent classes without breaking the behavior of the code.
*Bad Implementation*
Below, **TeslaToyCar** extends **Car** but does not support **fuel()** method as it is a toy. Hence violation the Liskov principle.
In our code, wherever we've used Car, we can't substitute it directly with TeslaToyCar because *fuel()* will throw Exception.
![Bad Implementation Liskov Substitution](/images/Liskov_Bad_Impl.png)
*Good Implmentation*
Creating a new sub-class **RealCar** from parent class **Car**, so that **RealCar** can support **fuel()** and **Car** can support generic functions support by any type of car
![Good Implementation Liskov Substitution](/images/Liskov_Good_Impl.png)

4. **Interface Segregation**
Interface should only have methods that are applicable to all child classes.
If an interface contains a method applicable only to some child classes, then we need to force the rest to provide dummy implementation.
*Bad Implementation*
Vehicle Interface contains the *fly()* method which is not supported by all Vehicles i.e Bus, Car etc, hence they are forced to provide a dummy implementation.
![Bad Implementation Interface Segregation](/images/Interface-Segregation-Bad-Impl.png)
*Good Implementation*
Pulling out *fly()* into a new Flyable Interface to solve the issue. Now the Vehicle interface contains methods supported by all Vehicles. And, Aeroplane implements both Vehicle and Flyable interfaces as it can fly too.
![Good Implementation Interface Segregation](/images/Interface-Segregation-Good-Impl.png)

5. **Dependency Inversion**
Class should depend on abstractions(interfaces and abstract class) instead of concrete implementations.
Makes sure classes are decoupled with each other.
*Bad Implementation*
We have a Service class, in which we've directly referenced concrete class; SQLRepository.
Issue: Our class now is tightly coupled with SQLRepository, in future if we need to start supporting NoSQLRepository then we need to change Service class.
![Bad Implementation Dependency Inversion](/images/Dependency-Inversion-Bad-Impl.png)
*Good Implementation*
Create a parent Interface Repository and SQL and NoSQL Repositories implement it. 
Service class refers to Repository interface, in future if we need to support NoSQL, then simply need to pass its instance in the constructor without changing Service class.
![Good Implementation Dependency Inversion](/images/Dependency-Inversion-Good-Impl.png)