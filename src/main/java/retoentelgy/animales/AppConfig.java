package retoentelgy.animales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Animal animal() {
        return new Animal("Ejemplo", TipoAnimal.TERRESTRE, "EjemploOnomatopeya");
    }
}
