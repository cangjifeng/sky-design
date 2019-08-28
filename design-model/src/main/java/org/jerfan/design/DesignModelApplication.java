package org.jerfan.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignModelApplication {

    /**
     * 访问 http://localhost:8013/start
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(DesignModelApplication.class, args);
    }

}
