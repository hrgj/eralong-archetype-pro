#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
@EnableDubbo
@EnableDiscoveryClient
@MapperScan("${package}.${parentArtifactId}.dao.mapper")
@ComponentScan("${package}.${parentArtifactId}")
public class WebApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    public WebApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        System.out.println("swagger-ui rul: " + "http://localhost:8083/tms/swagger-ui/index.html");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("server.port");
            String contextPath = environment.getProperty("server.servlet.context-path", "");

            String appUrl = String.format("http://%s:%s%s", hostAddress, port, contextPath);
            log.info("Application started at: {}", appUrl);
            log.info("Application started at: {}", appUrl);
        } catch (UnknownHostException e) {
            log.error("Could not determine application URL", e);
        }
    }
}
