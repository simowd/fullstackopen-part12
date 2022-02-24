FROM azul/zulu-openjdk:11.0.12
RUN apt update
RUN apt -y install wget curl
RUN wget https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh
VOLUME /opt/arquitectura/logs

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENV SPRING_PROFILE local
ENV SERVER_PORT 8762
ENV EUREKA_URI "http://localhost:8762/eureka"
ENV CONFIG_SERVER "http://localhost:8889"

ENTRYPOINT ["java", \
            "-cp", \
            "app:app/lib/*", \
            "arquitectura.software.msdiscovery.MsDiscoveryApplication"]