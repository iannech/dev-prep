# Caching and caching strategies
- What is Caching - [Read on Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#cache)

- Types of Caching
    - Client caching - OS or Browser
    - CDN Caching - Content Delivery Networks are considered some type of cache.
    - Web server caching e.g Reverse proxies and web servers can cache requests and responses.
    - Database Caching - DBs by default include some level of caching and are optimized for generic use cases.
    - [Application Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#application-caching) - In-Memory caches like **Memcached** and **Redis** are used.

- Read on [Application Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#application-caching) here to understand different caching levels.

- Some Cache Write Strategies

    ![Cache Write Strategies](/images/cach-write-strategies.svg)
## Cache Invalidation Methods
1. **Purge** - Removes cached content for a specific object, URL, or a set of URLs. Normally used when there's an update or change to the content and the cached version is no longer valid.
2. **Refresh** - The refresh method retrieves requested content from origin server, even if cached version is available. The cache then updates the content with the latest version from the origin server, ensuring up-to-date information. 
Unlike purge, refresh doesn't remove the existing cached content but just updates it with most recent version.
3. **Ban** - Invalidates the cached content based on specific criteria, such as a URL pattern or header. Upon receiving a Ban request, any cached content matching the criteria is immediately removed. 
Subsequent requests for the content will be served directly from the origin server, ensuring users receive most recent information.
4. **Time-to-live(TTL**) - Involves setting a ttl value for cached content, after which the content is considered stale and must be refreshed. When a request is received for content, the cache checks TTL and only serves the cached content if the value hasn't expired. If the content has expired the cache fetches the most recent version from origin server and updates it.
5. **Stale-while-revalidate** - Used in Web browsers and CDNs to serve stale content from the cache while the content is being updated in the background. When a request is received for a piece of content, the cached version is immediately served to the user, and an async request is made to the origin server to fetch latest content and update the cached content.
This ensures the user is always served content, even if the cached version is slightly outdated.

## Conclusion
- Cache invalidation strategy should be carefully chosen to balance the trade-off between performance and data accuracy.