FROM openjdk:17-jdk-slim

ENV TZ=Asia/Shanghai
ENV DEBIAN_FRONTEND=noninteractive

# 使用腾讯云镜像源加速
RUN sed -i 's|deb.debian.org|mirrors.cloud.tencent.com|g' /etc/apt/sources.list && \
    sed -i 's|security.debian.org|mirrors.cloud.tencent.com|g' /etc/apt/sources.list

# 安装字体和依赖
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    tzdata \
    curl \
    libfreetype6 \
    fontconfig \
    fonts-dejavu \
    fonts-wqy-zenhei \
    && rm -rf /var/lib/apt/lists/*

RUN fc-cache -fv

# 时区设置
RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone

# 应用配置
RUN mkdir -p /app/logs
WORKDIR /app
COPY tmscenter-web/target/tmscenter-web-*.jar /app/tmscenter-web.jar
EXPOSE 8090

ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0 \
-XX:InitialRAMPercentage=75.0 \
-XX:+UseContainerSupport \
-XX:+UseG1GC \
-XX:MaxGCPauseMillis=200 \
-XX:ParallelGCThreads=4 \
-XX:MaxMetaspaceSize=256m \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/app/logs/heapdump.hprof \
-XX:+ExitOnOutOfMemoryError \
-XX:ErrorFile=/app/logs/hs_err_pid%p.log \
-XX:OnOutOfMemoryError=\"kill -9 %p\" \
-Xlog:gc*,gc+heap=debug,gc+age=trace:file=/app/logs/gc_%p.log:time,uptime:filecount=5,filesize=100M \
-Dfile.encoding=UTF-8 \
-Duser.timezone=Asia/Shanghai"
CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/tmscenter-web.jar"]
