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

![alt text](/images/context-mapping.webp)

**Shared Kernel**
- Shared Kernel is a strategic pattern that involves identifying areas of commonality between different Bounded Contexts and establishing a shared subset of the domain model that is used by multiple contexts.
- This shared subset, or kernel, helps facilitate collaboration and integration between contexts while still allowing each context to maintain its own distinct model.
- Shared Kernel should be used judiciously, as it introduces dependencies between contexts and can lead to coupling if not managed carefully.
- In Code terms, it could be a shared library, or a service. 

![alt text](/images/shared-kernel.webp)

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