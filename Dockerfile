FROM openjdk:11 as build
COPY . /app
WORKDIR /app
RUN ./mvnw clean test package
RUN mkdir -p libs && mv target/*.jar libs/rle.jar

FROM openjdk:11
VOLUME /tmp
WORKDIR /app
COPY --from=build /app/libs/rle.jar app.jar
EXPOSE 9090
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]
