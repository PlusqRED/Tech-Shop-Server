package ru.course.server.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSpring {

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
