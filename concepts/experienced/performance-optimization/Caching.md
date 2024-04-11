# Caching and caching strategies
- What is Caching - [Read on Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#cache)

- Types of Caching
    - Client caching - OS or Browser
    - CDN Caching - Content Delivery Networks are considered some type of cache.
    - Web server caching e.g Reverse proxies and web servers can cacbe requests and responses.
    - Database Caching - DBs by default include some level of caching and are optimized for generic use cases.
    - [Application Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#application-caching) - In-Memory caches like **Memcached** and **Redis** are used.

- Read on [Application Caching](https://github.com/donnemartin/system-design-primer?tab=readme-ov-file#application-caching) here to understand different caching levels.

## Cache Invalidation