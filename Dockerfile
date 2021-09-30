FROM maven:3.8.1-jdk-11 as module-build

WORKDIR /module/rest

COPY . .

RUN mvn clean package

FROM payara/server-full:5.2021.7-jdk11

COPY --from=module-build /module/rest/word-frequency-server/target/*.war $DEPLOY_DIR
