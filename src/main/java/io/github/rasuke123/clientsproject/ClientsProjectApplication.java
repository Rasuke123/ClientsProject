package io.github.rasuke123.clientsproject;

import io.github.rasuke123.clientsproject.model.entity.Client;
import io.github.rasuke123.clientsproject.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ClientsProjectApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClientRepository repository ) {
        return args -> {
            Client client = new Client(null, "Antonio Marques", "12345678910", null);
            repository.save(client);
        };
    }




    public static void main(String[] args) {

        ///comando para correr o spring boot
        SpringApplication.run(ClientsProjectApplication.class, args);

    }

}
