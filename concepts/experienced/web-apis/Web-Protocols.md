## Http Protocol
- HTTP is unidirectional where the client sends the request and the server sends the response.
- This request goes in the form of HTTP or HTTPS, and after receiving a request server sends the response to the client, each request is associated with a corresponding response.
- After sending the response the connection gets closed, each HTTP or HTTPS request establish a new connection to the server every time and after getting the response the connection gets terminated by itself. 
- HTTP is a stateless protocol that runs on top of TCP(Transmission Control Protocol) which is a connection-oriented protocol it guarantees the delivery of data packet transfer using the three-way handshaking methods and re-transmits the lost packets.

![Http Connection](/images/HTTP-Connection.png)

## Web Socket
- WebSocket is bidirectional, a full-duplex protocol that is used in the same scenario of client-server communication, unlike HTTP which starts from ws:// or wss://.
- It is a stateful protocol, which means the connection between client and server will stay alive until it gets terminated by either party (client or server). 
- Once the communication link is established and the connections are opened, message exchange will take place in bidirectional mode until the connection persists between client-server. If anyone of them (client-server) dies or decide to close the connection then it is closed by both the party. 

Where can Web Socket be used:
1. Real-time web application like Trading - where data is continuously pushed/transmitted into the same connection to display price flactuation and movement using a web socket channel.
2. Gaming application
3. Chat application.