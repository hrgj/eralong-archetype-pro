FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y tzdata && \
    rm -rf /var/lib/apt/lists/*
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get update && apt-get install -y curl

RUN mkdir -p /app/logs
WORKDIR /app
# 设置环境变量
ENV JAVA_OPTS="-Xmx512m -Xms256m"

COPY tmscenter-web/target/tmscenter-web-0.0.1-SNAPSHOT.jar /app/tmscenter-web.jar
EXPOSE 8089
CMD ["java","-jar", "/app/tmscenter-web.jar"]