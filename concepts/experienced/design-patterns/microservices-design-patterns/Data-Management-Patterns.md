# Data Management Patterns

![Data Management Patterns](/images/data-management-patterns.png)

## Event-Sourcing Pattern
- Instead of storing the current state of data in a domain(using CRUD model), use an append-only store to record the full series of **actions** taken on the data. 
- You can then materialize domain objects from the store.
- Advantages:
    - Events are immutable and can be stored using append-only operation.
    - Can simplify tasks in complex domains, by avoiding the need to synchronize the data model and the business domain.
    - Improved performance.
    - Scalability 
    - Responsiveness
    - Can also provide consistency for transactional data and maintain full **audit trails** and **history**.
- The events are persisted in an event store that acts as the system of record (the authoritative data source) about the current state of the data.
- The Event store publishes these events so that consumers can be notified and can handle them if needed.
- The application code that generates(**publishes**) the events is decoupled from the systems that **subscribe** to the events.

    ![Event-Sourcing overview](/images/event-sourcing-overview.png)

Event-Sourcing is commonly combined with the **CQRS** pattern.
- Issues:
    - The system will be Eventually consistent when creating materialized views because there'll always be some delay between an application adding events to the event store due to the flow.
    - The event store is the permanent source of information, and so, the event data should never be updated. Only way to update an entity to undo a change is to add a compensating event to the event store. Migration might also be complex.
    - There's no standard approach like SQL for reading the events to obtain information.

    [Read More](https://learn.microsoft.com/en-us/azure/architecture/patterns/event-sourcing)

## Command and Query Responsibility Segregation (CQRS)
- Is a pattern that separates **read** and **update** operations for a data store.
- CQRS maximizes performance, scalability and security in your application.
- In traditional architectures, the same data model is used to query and update a database. That's simple and works well for basic CRUD operations. In more complex applications, however, this approach can become unwieldy.
- This separation of concerns allows the software development team to adapt models that are more manageable and offer greater flexibility. The flexible nature of this design pattern can also be beneficial for systems that evolve over time.
    #### Solution
- CQRS separates reads and writes into different models, using **commands** to update data, and **queries** to read data.
- Commands should be task-based, rather than data-centric ("Book hotel room", not "set ReservationStatus to Reserved"). 
- Run some validation rules on the client even before sending the command, possibly disabling buttons, explaining why on the UI ("no rooms left"). 
- Commands may be placed on a queue for **asynchronous processing**, rather than being processed synchronously.
- Queries can never modify the database.
    ![CQRS](/images/command-and-query-responsibility-segregation-cqrs-basic.png)
- Reads can use own data schema optimized for queries e.g a Materialized view of the data in order to avoid complex joins etc. Might even use a different type of data store.
- Some implementations of CQRS uses **Event-Sourcing pattern**.
- Benefits of CQRS include:
    - Independent scaling. CQRS allows the read and write workloads to scale independently, and may result in fewer lock contentions.
    - Optimized data schemas. The read side can use a schema that is optimized for queries, while the write side uses a schema that is optimized for updates.
    - Security. It's easier to ensure that only the right domain entities are performing writes on the data.
    - Separation of concerns. Segregating the read and write sides can result in models that are more maintainable and flexible. Most of the complex business logic goes into the write model. The read model can be relatively simple.
    - Simpler queries. By storing a materialized view in the read database, the application can avoid complex joins when querying.

- Issues:
    - Complexity - in design and implementation.
    - Eventual Consistency - coz of separation of read and writes
    - Messaging - Although CQRS does not require messaging, it's common to use messaging to process commands and publish update events. In that case, the application must handle message failures or duplicate messages

- When to us CQRS:
    - Collaborative domains where many users access the same data in parallel.
    - Task-based user interfaces where users are guided through a complex process as a series of steps or with complex domain models.
    - Scenarios where performance of data reads must be fine-tuned separately from performance of data writes.
    - Integration with other systems, especially in combination with event-sourcing.

    [Read More](https://learn.microsoft.com/en-us/azure/architecture/patterns/cqrs)