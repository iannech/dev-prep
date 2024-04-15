# Observability patterns for Microservices
Continuous Monitoring is one of the cornerstones of Microservices architecture. Observability patterns like the ones below help achieve this.

## Distributed Tracing
- In a Microservices architecture, requests may span multiple services. Each services deals with a client request by performing one or more operations across multiple services. This can make troubleshooting difficult as it's hard to track requests end-to-end.
- Distributed tracing = solution. The distributed tracer gives each request a unique ID. It also records information about the requests e.g which services are called, which actions are performed.
- Developers can use this info to trace requests from beginning to end, helping them find the root cause of any issues. 
- They can also monitor how services interact and how long it takes each service to process requests, which is useful for pinpointing latency.

    ![Distributed Tracing](/images/Distributed%20tracing.webp)

#### Examples
1. Python(FastAPI) - You could use **OpenTelemetry**, an open source Observability framework. [Open Telemetry](https://uptrace.dev/get/instrument/opentelemetry-fastapi.html#what-is-opentelemetry)
2. Java (Springboot) - **Spring Cloud Sleuth** and **Zipkin server** [Distributed tracing for Springboot](https://microservices.io/patterns/observability/distributed-tracing.html)

## Log Aggregation
- Each Microservice generates a standardized log file for it's activities. Useful in cases where an application may consist of several services.
- However, there needs to be a centralized logging service that can compile logs from each service instance.
- Log aggregation - normalizes and consolidates logs from different microservices and stores them on a centralized platform.
- Developers can search and analyze logs on the platform. They can also create alerts that are triggered when certain problem messages appear, simplifying issue resolution.

#### Examples
- **Loguru** - is a Python Logging library that offers robust logging services with automatic log rotation and compression. It can be used with **Sentry** - a tool that offers Error Handling and Monitoring by providing real-time error alerts, detailed error reports and performance insights.     [Read More](https://marketsplash.com/fastapi-logging/)

## Performance Metrics
- It's important to keep an eye on transactions to that patterns can be monitored and problems identified. However, with a growing number of services this can be painful.
- With performance metrics pattern, you can either gather data about individual operations (e.g latency and cpu utilization) and consolidate it. 
- The pattern aggregates the metrics of different services into a single metrics service that offers reporting and altering capabilities.
- It provides a consolidated view of how the architecture is performing.
- Two methods for this: push(which pushes metrics to metrics service), pull(which pulls metrics from metrics service). 

## Health Check
- This pattern dictates having a health check API endpoint on all services that returns the health of the services.
- The API endpoint handler might perform various checks such as:
    - The status of the connections to the infrastructure services used by service instance.
    - The status of the host e.g disk space.
    - Application specific logic.

    
