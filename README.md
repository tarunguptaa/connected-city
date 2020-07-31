# Connected City API

This API will tell you whether there is a connection available between two cities or not.

## Getting Started

### API :
```
http://localhost:8080/connected?city1=<cityname>&city2=<cityname>
```

### @Returns
```
yes | no
```

### Swagger Documentation:
```
http://localhost:8080/swagger-ui.html
```


### Prerequisites


```
1. jdk 8 or above.
2. Eclipse or any other IDE if don't want to use command line tool.
```

### Installation Steps

```
1. Clone the repo in your local
2. Build using ./gradlew clean build or using gradle build plugin in IDE
3. Run ./gradlew bootRun or run main class as java application to start the application.
And you good to invoke API
```

For Ex: http://localhost:8080/connected?city1=New%20York&city2=Boston will return yes.

## Running the tests

```
./gradlew test or run test files as junit tests in IDE.
```

## Built With

* [Springboot](https://spring.io/projects/spring-boot) - The web framework used
* [Gradle](https://gradle.org/) - Build & Dependency Management
* [Swagger](https://swagger.io/) - Used for API documentation


## Authors

* **Tarun Gupta**