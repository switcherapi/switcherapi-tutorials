FROM ghcr.io/graalvm/graalvm-community:25.0.2 AS build

ARG MAVEN_VERSION=3.9.16
ARG MAVEN_BINARY=https://downloads01-he-fi.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz

RUN mkdir -p /usr/share/maven /usr/share/maven/ref
ADD ${MAVEN_BINARY} /tmp/apache-maven.tar.gz
RUN tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
    && rm -f /tmp/apache-maven.tar.gz \
    && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

WORKDIR /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

RUN mvn -DskipTests -Pnative native:compile

FROM debian:bookworm-slim

WORKDIR /app

COPY --from=build /usr/src/app/target/switcher-playground-java-native /app/switcher-playground-java-native

CMD ["/app/switcher-playground-java-native"]