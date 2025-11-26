package ec.edu.arquitecturac4.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Versión simple: crea un RestTemplate con la configuración por defecto
        return new RestTemplate();
    }
}