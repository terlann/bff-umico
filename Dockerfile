FROM openjdk:11.0.3-jdk-slim-stretch 
ARG DEPLOY_ENV
WORKDIR /app
ENV TZ Asia/Baku
COPY *.*ar .
COPY kapitalho.der /app/
RUN ln -sfn *.*ar app
RUN keytool -importcert -alias kbsrvpki -keystore  $JAVA_HOME/lib/security/cacerts -storepass changeit -file kapitalho.der -noprompt
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "./app", "--spring.profiles.active=${DEPLOY_ENV}"]
CMD [""]
