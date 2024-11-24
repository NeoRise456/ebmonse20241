package org.hign.platform.u202110237.ebmonse20241;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ebmonse20241Application {

    public static void main(String[] args) {
        SpringApplication.run(Ebmonse20241Application.class, args);
    }

}
