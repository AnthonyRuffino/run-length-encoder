# Run-Length Encoder

This application fetches large amounts of repetitive data containing characters separated by newlines from an external service. It then caches that data using a [Run-length Encoding](https://en.wikipedia.org/wiki/Run-length_encoding) algorithm.  

It then makes the data available by index via the following url:  

```http://localhost:1337/{index}```



## Tech Stack
This application uses Spring Boot and an in-memory H2 database for easy querying of the cached data.  

This application is dependant on another micro-service serving the character data.  


### Clone the repo

```bash
git clone https://github.com/AnthonyRuffino/run-length-encoder.git
```

### Properties
The URL for the character service can be configured via the ```characterService``` property in the [property file](src/main/resources/application.properties)  

The URL for the character service can be configured ```fetchDelay``` property.

### Run the required character service
This application depends on another microservice to serve large streams of character data.  
The following command will run one such a container.  Make sure the host port matches the port from the ```characterService``` property
```bash
docker run -p 8080:80 21re/coding-challenge
```


### Run with Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Testing
Open your browser to [http://localhost:1337/{index}](http://localhost:1337/1)

### Run with Docker
You can build and then run this application with Docker, but you will need to run it on the same [network](https://docs.docker.com/network/) as the character service.  
You would then have to set the the ```characterService``` property accordingly.

```bash
docker build -t anthonyruffino/rle .
```



## License
[MIT](https://choosealicense.com/licenses/mit/)
