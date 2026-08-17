package br.edu.ifsp.bra.intro_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public User generateUser(){
        User user = new User();
        user.setLogin("User-1");
        user.setSenha("1234");
        return user;
    }
}
