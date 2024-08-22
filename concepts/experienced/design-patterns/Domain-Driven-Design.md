# Domain-Driven-Design

## What is Domain-Driven-Design?
**Domain** - Refers to the subject area or problem space that the software system is being built to address. It encompasses the real-world concepts, rules and processes that the software is intended to model or support.

**Driven** - implies that the design of the software system is being guided/influenced by the characteristics and requirements of the domain.

**Design** - Refers to the process of creating a plan or blueprint for the software system, including  decisions about how the system will be structured, how different components will interact and how the system will fulfill its functional and non-functional requirements.

### Importance of Domain Knowledge
Suppose we have designed software using all the latest tech stack and infrastructure and our software design architecture is amazing, but when we release this software in the market, it is ultimately the end user who decides whether our system is great or not. Also if the system does not solve business needs, then it is of no use to anyone. No matter how pretty it looks or how well the architecture its infrastructure are.
According to Eric Evans, When we are developing software our focus should not be primarily on technology, rather it should be primarily on business. 

## Strategic Design in Domain-Driven-Design
- Strategic Design in Domain-Driven-Design focuses on defining the overall architecture and the structure of a software in a way that aligns with the problem domain.
- It addresses high-level concerns such as how to organize domain concepts, how to partition the system into manageable parts and how to establish clear boundaries between different components.

### Concepts within Strategic Design in Domain-Driven-Design
1. Bounded Contexts
- A Bounded context represents a specific area within the overall problem domain where a particular model or language applies consistently.
- Different parts of a system may have different meanings for the same terms, and a Bounded Context defines explicit boundaries within which those terms have specific meanings.
- This allows teams to develop models that are tailored to specific contexts without introducing confusion or inconsistencies.
- Bounded Contexts help manage complexity by breaking down a large, complex domain into smaller, more manageable parts.

2. Context Mapping
- Context Mappping is the process of defining the relationships and interactions between different Bounded Contexts.
- It involves identifying areas of overlap and integration between contexts and establishing communication channels and agreements between them.
- There are various patterns and techniques for Context Mapping such as Partnership, Shared Kernel and Customer-Supplier.

![Context Mapping](/images/context-mapping.webp)

**Shared Kernel**
- Shared Kernel is a strategic pattern that involves identifying areas of commonality between different Bounded Contexts and establishing a shared subset of the domain model that is used by multiple contexts.
- This shared subset, or kernel, helps facilitate collaboration and integration between contexts while still allowing each context to maintain its own distinct model.
- Shared Kernel should be used judiciously, as it introduces dependencies between contexts and can lead to coupling if not managed carefully.
- In Code terms, it could be a shared library, or a service. 

![Shared Kernel](/images/shared-kernel.webp)

**Partnership**
- Partnership describes more about the relationship between teams as opposed to actual code.
- Typically happens when 2 teams working together on 2 bounded contexts are aligned on set of goals, each team should at least understand some of their partner's Ubiquitous Language, namely the things that are interesting to their own context.

**Customer-Supplier**
- This approach puts 2 Bounded Contexts into an *upstream* and *downstream*, where the upstream is the supplier, and has to try meet the expectations of the customer(downstream). But the final decision of what the customer gets comes from the supplier.
- Typically works in an autonomous environment within the same organization, or if the customer is sole client of the supplier.

**Anti-Corruption Layer**
- Is another upstream/downstream relationship that helps protect a system from the influence of external or legacy systems that use different models or languages.
- An ACL acts as a translation layer between the external system and the core domain model, transforming data and messages as needed to ensure compatability.
- This allows the core domain model to remain pure and focused on the problem domain, while still integrating with external systems as necessary.

**Conformist**
- This describes a relationship of 2 Bounded Contexts where the upstream has no interest in supporting the downstream for whatever reason. Instead, the downstream must conform to whatever upstream provides.
- Can happen when integrating a new feature with a large, existing solution that is well established, or using a set of APIs, where the downstream is not the sole customer.

**Open Host Service(OHS) and Published Language**
- Both define a relationship where the upstream provides a set of well documented or readily available information about the integration models.
- This is built on top of the **Conformist** approach, where the downstream is a lot more tolerable.
- The upstream also provides version support. Typically, the upstream Bounded Context will support multiple clients and has no interest in especially supporting a particular one. eg 3rd party APIs like Stripe, AWS etc

### Ubiquitous Language
- Ubiquitous Language refers to a shared vocabulary or language that is used consistently and universally across all stakeholders in the development of a software system.
- The language consists of terms, phrases and concepts that accurately represent domain knowledge and concepts.

**Principles of Ubiquitous Language**
1. Shared Understanding - primary goal of UL is to establish understanding of the problem domain among all members of development team i.e developers, domain experts, business analysts and stakeholders.
2. Consistency and Clarity - Ubiquitous Language promotes consistency and clarity in communication by using precise and unambiguous terminology. Each term or phrase in the language should have a clear and agreed-upon meaning.
3. Alignment with Business Concepts - The language used in DDD should closely align with the terminology and concepts used in the business domain. It should reflect the way domain experts think and talk about the problem domain, ensuring that the software accurately represents real-world concepts and processes.
4. Evolutionary Nature - UL is not static but evolves over time as the team gains a deeper understanding of the domain and as requirements change. It should adapt to reflect new insights, discoveries, or changes in business priorities, ensuring that the language remains relevant and up-to-date throughout the development process.


## Tactical Design Patterns in Domain-Driven-Design
Tactical DDD patterns are applied within a single Bounded context.
In a Microservice architecture, each Bounded context is a candidate for a Microservice. And as a general principle; a Microservice should be no smaller than an aggregate and no larger than a Bounded Context.
1. Entity - is a domain object that has a distinct identity and lifecylce. They are characterized by their unique identifiers and mutatable state. They encapsulate data and behavior related to a specific concept within the domain. e.g BankAccount or Customer entity in banking application
2. Value Object - is a domain object that represents a conceptually immutable value. Unlike entities it doesn't have a distinct identity and are typically used to represent attributes or properties of entities. They are equality-comparable based on their properties, rather than identity.
Examples include: colors, date, times, currency value etc
3. Aggregate - is a cluster of domain objects that are treated as a single unit for the purpose of data consistency and transaction integrity.
- Aggregates consist of one or more entities and value objects, with one entity designated as the aggregate root.
- Aggregate root serves as the entry point for accessing and modifying the aggregate's internal state.
- Aggregates enforce consistency boundaries within the domain model.
- Example: *in an e-commerce system, an Order aggregate might consist of entities like OrderItem and Customer(children of root), with Order entity = aggregate root.*
4. Repository - is a mechanism for abstracting data access and persistence logic from the domain model.
- Repositories provide standardized interface for querying and storing domain objects, hiding the details of how data is stored or retrieved.
- By decoupling the domain model from data access concerns, repositories enable greater flexibility and maintainability.
5. Factory - is a creational pattern used to encapsulate the logic of creating instances of complex domain objects. The abstract the process of object instantiation, allowing the client to create objects without needing to know details of their construction.
6. Service - is a domain object that represents a behavior or operation
- Service encapsulates the business/domain logic that operates on multiple objects  or orchestrates interactions between objects.
- Services are typically stateless and focus on performing specific tasks or enforcing domain rules.

## Benefits of Domain-Driven-Design
1. Shared understanding
- Encourages collaboration between domain experts, developers and stakeholders.
- Shared Understand through UL = effective teams communication
2. Focus on Core Domain
- Helps teams identify and prioritize the core domain of the application.
3. Resilience to change
- Which it emphasizes by modeling the domain in a way that reflects the inherent complexities and uncertainties of the domain.
- By embracing change as a natural part of software development, teams can respond more effectively to evolving business needs & market conditions
4. Clear separation of Concerns
- By encouraging clear separation of concerns between domain logic, infrastructure concers and user interface concerns, teams can maintaina clean and focused domain model that is independent of specific implementation details or technological details.
5. Improved Testability
- It promotes use of domain objects with well-defined boundaries and behaviors, making it easier to write better and focused tests to verify correctness of domain logic.
6. Support for Complex Business Rules
- Provides patterns and techniques for modeling and implementing complex business rules and workflows within the domain model.
7. Alignment with Business Goals
- By focusing on understanding and modeling the problem domain, teams can deliver software solutions that directly support business objectives, drive innovation and create value for stakeholders and end-users.

## Challenges of Domain-Driven-Design
1. Complexity
- DDD introduces complexity especially in large complex domains
- Modeling intricate business domains requires a deep understanding of the domain and may involve dealing with ambiguity and uncertainty.
2. Ubiquitous Language Adoption
- Establishing and maintaining a UL can be challenging as it requires developers and domain experts to identify and agree upon domain terms and meanings
3. Bounded Context Alignment
- It can be challenging to align Bounded contexts and ensuring consistency between them in a large and complex domains. Lots of communication, collaboration and coordination between teams is required.
4. Technical Complexity
- Implementing DDD patterns effectively may require adopting new tech, frameworks and architectural approaches. Integrating DDD with existing or legacy systems can be complex with lots of refactoring.
5. Resistance to Change from team members
6. Over-Engineering
- This is a risk where a team focuses too much on modeling complex domain concepts and introducing unneccessary abstractions or complexity.

## Use-Cases of Domain-Driven-Design

1. Finance and Banking:
- In the finance sector, DDD can be used to model complex financial instruments, transactions, and regulatory requirements. By accurately representing domain concepts such as accounts, transactions, and portfolios, DDD helps ensure the integrity and consistency of financial systems. It also enables better risk management, compliance, and reporting.
2. E-commerce and Retail:
- E-commerce platforms often deal with complex domain concepts such as product catalogs, inventory management, pricing, and customer orders. DDD can help model these concepts effectively, enabling features such as personalized recommendations, dynamic pricing, and streamlined order processing.
3. Healthcare and Life Sciences:
- In healthcare, DDD can be used to model patient records, medical diagnoses, treatment plans, and healthcare workflows. By accurately representing domain concepts such as patient demographics, medical histories, and clinical protocols, DDD enables the development of robust electronic health record (EHR) systems, medical imaging platforms, and telemedicine applications.
4. Insurance:
- Insurance companies manage diverse products, policies, claims, and underwriting processes. DDD can help model these complex domain concepts, enabling features such as policy management, claims processing, risk assessment, and actuarial analysis.
5. Real Estate and Property Management:
- Real estate and property management involve handling diverse properties, leases, tenants, maintenance requests, and financial transactions. DDD can help model these domain concepts effectively, enabling features such as property listings, lease management, tenant portals, and asset tracking.


## Real-world Example of Domain-Driven Design (DDD)
### Problem Statement
Lets say, we are developing a ride-hailing application called “RideX.” The system allows users to request rides, drivers to accept ride requests, and facilitates the coordination of rides between users and drivers.

#### Ubiquitous Language
1. User: Refers to individuals who request rides via the RideX platform.
2. Driver: Refers to individuals who provide rides to users via the RideX platform.
3. Ride Request: Represents a user’s request for a ride, specifying details such as pickup location, destination, and ride preferences.
4. Ride: Represents a single instance of a ride, including details such as pickup and drop-off locations, fare, and duration.
5. Ride Status: Represents the current status of a ride, such as “Requested,” “Accepted,” “In Progress,” or “Completed.”

#### Bounded Contexts
1. Ride Management Context: Responsible for managing the lifecycle of rides, including ride requests, ride assignments to drivers, and ride status updates.
2. User Management Context: Handles user authentication, registration, and user-specific features such as ride history and payment methods.
3. Driver Management Context: Manages driver authentication, registration, availability status, and driver-specific features such as earnings and ratings.

#### Entities and Value Objects
1. User Entity: Represents a registered user of the RideX platform, with properties like user ID, email, password, and payment information.
2. Driver Entity: Represents a registered driver on the RideX platform, with properties like driver ID, vehicle details, and driver status.
3. Ride Request Entity: Represents a user’s request for a ride, including properties like request ID, pickup location, destination, and ride preferences.
4. Ride Entity: Represents a single instance of a ride, including properties like ride ID, pickup and drop-off locations, fare, and ride status.
5. Location Value Object: Represents a geographical location, with properties like latitude and longitude.

#### Aggregates
1. Ride Aggregate: Consists of the Ride Entity as the aggregate root, along with related entities such as Ride Request, User, and Driver entities. The Ride Aggregate encapsulates the logic for managing the lifecycle of a ride, including handling ride requests, assigning drivers, and updating ride status.

#### Repository
1. Ride Repository: Provides methods for querying and storing ride-related entities, such as retrieving ride details, updating ride status, and storing ride-related data in the database.

#### Services
1. Ride Assignment Service: Responsible for assigning available drivers to ride requests based on factors such as driver availability, proximity to pickup location, and user preferences.
2. Payment Service: Handles payment processing for completed rides, calculating fares, processing payments, and updating user and driver payment information.

#### Domain Events
1. RideRequestedEvent: Represents an event triggered when a user requests a ride, containing information such as the ride request details and user ID.
2. RideAcceptedEvent: Represents an event triggered when a driver accepts a ride request, containing information such as the ride ID, driver ID, and pickup location.

#### Example Scenario
1. User Requesting a Ride: A user requests a ride by providing their pickup location, destination, and ride preferences. RideX creates a new ride request entity and triggers a RideRequestedEvent.
2. Driver Accepting a Ride: A driver accepts a ride request from the RideX platform. RideX updates the ride status to “Accepted,” assigns the driver to the ride, and triggers a RideAcceptedEvent.
3. Ride In Progress: The user and driver coordinate the ride, with the ride status transitioning from “Accepted” to “In Progress” once the driver reaches the pickup location.
4. Ride Completion: After reaching the destination, the ride status is updated to “Completed.” RideX calculates the fare, processes the payment, and updates the user and driver payment information accordingly.
