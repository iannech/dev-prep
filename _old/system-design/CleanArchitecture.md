### What is Clean Architecture?

- Separates the elements of a desig into circle levels
- Keep the core business logic and application domain at the center of the solution structure that is independent of the presentation and data access layers.![Clean Architecture](CleanArchitecture.jpg)
- Two main elements:
  - Policies - business rules and procedures.
  - Details - implementation code to carry out the policies.
- _Dependecy rule_
  - Code dependency can only move from the outer levels inward.
  - Code on the inner layers have no knowledge of the functions on the outer layers
  - Inner layer canot have any information about elements of outer layers.
- Benefits of Clean Architecture

  - Independent Database and frameworks
  - Independence of UI
  - Testable
  - Independence of any external agency

- Drawbacks of Clean Architecture
  - Layers are independent but those layers are technical
  - Vertical business logic implementation requires us to modify all layers i.e add to basket, checkout order use cases.
  - It is still monolithic and has scalability issues.
