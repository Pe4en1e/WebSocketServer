package me.pe4en1e.websocketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WebSocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketServerApplication.class, args);
    }

}
