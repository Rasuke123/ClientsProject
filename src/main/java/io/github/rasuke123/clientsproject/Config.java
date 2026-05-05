package io.github.rasuke123.clientsproject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sells System";
    }



}
