FROM adoptopenjdk/openjdk11

MAINTAINER AniruddhaSinha <Aniruddha.Sinha@globalpay.com>

VOLUME /tmp

EXPOSE 8080

ADD target/*.jar app.jar

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]