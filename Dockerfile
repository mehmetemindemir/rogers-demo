FROM openjdk:11

ADD ./target/demo-0.0.1-SNAPSHOT.jar /

CMD ["java","-Xmx1024m","-Xss1024m", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
