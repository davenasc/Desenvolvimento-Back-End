package br.edu.ifsp.bra.intro_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public User generatUser() {
        User user = new User();
        user.setLogin("user");
        user.setPassword("pass");
        return user;
    }

}
