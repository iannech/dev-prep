# Integration Patterns

## API Gateway 
- The API gateway design pattern can be considered a proxy services. It grants a single entry point for all Microservices and routes a request to the correct service or services.
- By using an API gateway, microservices can communicate with each other via a stateless server eg using HTTP requests or a message bus.
- The pattern also insulates the clients from needing to know how services are partitioned.
- Security such as Authentication and Authorization can be done at the API gateway layer for the entire service ecosystem.
- SSL Termination and Caching can also be achieved at this layer.

![Api Gateway Pattern](/images/api-gateway.webp)

## Backend for Frontends (BFF)
- This is a variant of the API Gateway pattern that provides an extra layer between client applications and microservices.
- Unlike API Gateway, BFF isn't a single point of entry. Instead, it introduces a separate gateway for each client. 
- Example: A company might have a Web app, a Mobile app and a third-party app. With BFF pattern, an API can be added for each app instead of a single bloated API being used for all 3. This not only improves user experience but also enhances system performance as each app can call the backend in parallel.
- This pattern can also be used to accommodate the functions of particularly complex apps or create separate gateways for different business domains.

![BFF Pattern](/images/bff-pattern.png)

To read more on BFF:
[Understanding Web Security for BFF](https://dev.to/damikun/web-app-security-understanding-the-meaning-of-the-bff-pattern-i85)

## Aggregator Design Pattern
- This design pattern is used to collect pieces of data from various Microservices and returns and aggregate for processing. 
- Although similar to BFF, an Aggregator is more generic and not explicitly used for UI.
- To complete tasks, an Aggregator pattern receives a request and sends out requests to multiple services, based on the tasks it was assigned. Once every service has answered the requests, it combines the results and initiates a response to the original request.

![Aggregator Pattern](/images/aggregator-pattern.webp)