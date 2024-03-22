# Authentication, Authorization, Oauth, OpenId Connect

## What are authentication and authorization?
In simple terms, **authentication** is the process of verifying who a user is, while **authorization** is the process of verifying what they have access to.

Comparing these processes to a real-world example, when you go through security in an airport, you show your ID to authenticate your identity. Then, when you arrive at the gate, you present your boarding pass to the flight attendant, so they can authorize you to board your flight and allow access to the plane.

## Authentication vs. authorization

Here's a quick overview of the differences between authentication and authorization:

| Authentication                                  | Authorization                               |
| ------------------------------------------------|--------------------------------------------- |
| Determines whether users are who they claim to be	| Determines what users can and cannot access |
| Challenges the user to validate credentials (for example, through passwords, answers to security questions, or facial recognition) | Verifies whether access is allowed through policies and rules |
| Usually done before authorization	 | Usually done after successful authentication |
| Generally, transmits info through an ID Token	| Generally, transmits info through an Access Token |
| Generally governed by the OpenID Connect (OIDC) protocol	| Generally governed by the OAuth 2.0 framework |
| Example: Employees in a company are required to authenticate through the network before accessing their company email	| Example: After an employee successfully authenticates, the system determines what information the employees are allowed to access |

## Oauth 2 and OpenID Connect
1. [Oauth 2.0 and OpenID Connect for Dummies](https://medium.com/israeli-tech-radar/oauth-2-0-and-openid-connect-for-dummies-6fa6e995d6d5)
2. [OpenID Connect Explained](https://connect2id.com/learn/openid-connect#auth-request)