# GraphQL

- It is a query language for APIs
- Provides access to many resources in a single request reducing the number of network calls.
- Ask for what you need, get exactly that.
- Evolve APIs without versions by adding new fields and types to GraphQL API without impacting existing queries.

## GraphQL Core Concepts

1. **Schema** - describes all the possible data that clients can query on. Made up of object types and their fields.
2. **Resolver** - function that attaches to fields in a schema. Resolver is called to produce the value during execution.
3. **Mutation** - an operation that allows you to insert new data or modify the existing data on the server side.

## Advantages of GraphQL

- Fast - way faster than REST, coz reduces multiple calls to get data.
- Single request - one call, all data
- Strongly typed - we describe the data before querying it, reducing miscommunication.
- Hierarchical structure - relationships between objects are defined in a graphical structure.
- Evolving API without breaking existing queries

## Drawbacks of GraphQL

- Query complexity might result in performance issues - when accessing multiple fields in one DB query, may request too many nested fields data at a single time that could cause performance problems. We must have **MAX** query depth to avoid this.
- Caching complexity - complicated to cache because each query can be different even though it operates on the same entity.
- Complex to specify Rate Limiting - in REST, it's easier to specify amount of requests allowed at at time than in GraphQL

[GraphQL Documentation](https://www.howtographql.com/basics/2-core-concepts/)