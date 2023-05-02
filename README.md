XMeme is a simple backend web application where users can post and see memes.

-Created a Backend Server using Spring template with the REST API handlers.
-Implemented support for POST API that can be used to post Memes.
-Implemented support for GET API that can be used to fetch the 100 newest memes posted, including these fields - name, caption and image URLs.
-Implemented support for GET API to fetch individual Memes using Meme Id.
-Used MongoDB to store the Meme related fields and extract them.
-Handled incorrect requests and used appropriate HTTP Response codes for error scenarios.
-Tested the functionality and wrote code with clear comments and documentation.
-Wrote modular code following MVCS layering architecture.

Skills used
Core Java, Backend Server, Jackson, Spring Boot, Spring Data, REST API, MongoDB, Docker and Swagger

What's included: 
1. Gradle file created from start.spring.io
2. Plugins for Spotbugs, Checkstyle and Jacoco included
3. Other dependencies like Mongo, MySql

Usage - 
1. To build the repository - 
From the repository root, 
1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.

