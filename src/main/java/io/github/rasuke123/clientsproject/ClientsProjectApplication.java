package io.github.rasuke123.clientsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientsProjectApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;



    public static void main(String[] args) {

        ///comando para correr o spring boot
        SpringApplication.run(ClientsProjectApplication.class, args);

    }

}
