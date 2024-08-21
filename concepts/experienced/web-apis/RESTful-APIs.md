# REST APIS

## What is REST
- REST, which stands for Representational State Transfer, is an architectural style for designing networked applications.
- It is based on a set of principles that emphasize simplicity, scalability and statelessness, which allow developers to build web services that are easy to understand, maintain and scale.
- REST API is a type of web service designed to interact with resources on the web, such as web pages, files etc.

## REST API Principles
1. Statelessness

REST API is stateless, meaning each request from the client to the server must contain all the necessary information to process the request. The server does not maintain any session state between the requests. This principle makes the API scalable and reliable.

2. Uniform Interface

REST API should have a uniform interface that is consistent across all resources. This helps simplify the API and promotes reusability.

3. Cacheability

REST API supports caching of responses to improve performance and reduce server load. The server can set caching headers to indicate whether the response can be cached or not.

4. Client-Server Architecture

REST API is based on client-server architecture model, client sends a request to the server, the server returns a response. Helps promote loose coupling between client and server.

5. Layered System

A REST API is a system composed of multiple layers, each of which has a single purpose. Most common example is a three-tier system made up of 3 layers: data access, business logic, and presentation.

6. Code on Demand(optional)

REST API supports the execution of code on demand. The server can return executable code in the response to the client which can be executed on the client side.

## REST API Methods
1. GET - Used to retrieve resource from the server.
2. POST - Used to create new resource on the server. POST Method is NOT Idempotent i.e multiple identical requests will create multiple resources.
3. PUT - Used to update an existing resource on the server. PUT Method IS Idempotent i.e multiple identical requests will have the same effect on a single request.
4. DELETE - Used to delete an existing resource on the server. DELETE Method IS Idempotent i.e multiple identical requests will have the same effect on a single request.

Other Methods that can be useful in RESTful APIs: 
- PATCH - Used to partially update a resource.
- CONNECT - Used to establish network connection with a resource.
- TRACE - Used to retrieve diagnostic information about a resource.
- OPTIONS - Used to retrieve available methods for a resource.

## Best Practices for Designing RESTful APIs
1. **Follow RESTful principles**

    RESTful principles include using HTTP methods appropriately (GET, POST, PUT, DELETE), using resource URIs to identify resources, returning proper HTTP status codes, and using hypermedia controls (links) to guide clients through available actions. Adhering to these principles makes your API easy to understand and use. 

2. **Use Nouns instead of verbs in URI**

    For example, instead of using **“/create_user”**, use **“/users”** to represent a collection of users and **“/users/{id}”** to represent a specific user. 

3. **Use HTTP methods appropriately**

4. **Use Proper HTTP status codes**

    Use the appropriate status codes (such as 200, 201, 204, 400, 401, 404, etc.) to indicate the success or failure of the API call.

5. **Provide consistent response formats.**
    Such as JSON or XML consistently.

6. **Use Versioning**

    When making changes to your API, use versioning to ensure backwards compatibility. For example, use “/v1/users” instead of “/users” to represent the first version of the API.

7. **Document your API**

    Documenting your API is critical to ensure that users understand how to use it. Include details about the API, its resources, parameters, response formats, endpoints, error codes, and authentication mechanisms.

8. **Implement Security**

    Security is crucial for protecting your API and user data. Implement proper authentication and authorization mechanisms, such as OAuth2, to ensure that only authorized users can access your API.

9. **Optimize Performance**

    Optimize your API’s performance by implementing caching, pagination, and compression techniques. Use appropriate HTTP headers and compression techniques to reduce the size of your responses.

10. **Test and Monitor your API**

    Test your API thoroughly to ensure that it meets user requirements and performance expectations. Monitor your API’s performance using metrics such as response times, error rates, and throughput, and use this data to improve the quality of your API.
11. [**Rate Limiting and Throttling**](https://apidog.com/blog/rate-limiting-vs-throttling/#rate-limiting-features)
    Rate Limiting is a control mechanism that limits the number of requests a user can make to an API within a specific time frame.
    Throttling on the other hand, adjusts the pace at which applications can make API calls, ensuring that the system remains stable and functional under varying loads (It's like a dynamic speed limit for data traffic).
## Optimizing API Performance
- **Pagination** - when you have large data to send, break it into chunks and send as paged results to reduce load and reduce response time.
- **Caching** - use different caching with tools like redis to cache data you use frequently and reduce response time,
- **Payload compression** - shrink the size of payload you're sending and receiving with tools like gzip for faster upload and downloads.
- **Asynchronous logging** - instead of writing logs to disk directly, you offload this to a logger worker node/service that reads the logs from a queue/topic and do the writing to disk for your service.
- **Connection Pool**- Instead of opening and closing DB connections all the time, make use of connection pool to keep these connections ready to go.

## Advantages of REST APIs
- Simplicity and flexibility
- Platform independence
- Scalability
- Performant and efficient
- Portability and ease of integration

## Disadvantages of REST APIs
- Statelessness of REST can lead to larger requests since all necessary data must be included in the request.
- Data overfetching and underfetching which can impact performance as multiple requests might be needed to gather all data.
- Security concerns are a potential challenge, requiring proper auth implementation.
- Versioning of REST APIs can be complex with changes potentially breaking backward compatibility.
- Lack of strict standard in REST implementation can lead to inconsistencies across different APIs
- Potential performance bottlenecks due to HTTP/HTTPS overhead when the APIs are highly scaled out.
