package retoentelgy.animales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Animal animal() {
        // Este es un ejemplo de cómo crear un Bean con Spring
        return new Animal("león", "terrestre", "roar");
    }
}
