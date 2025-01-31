package retoentelgy.animales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private Animal animal;

    // Configuración inicial de las pruebas (Método ejecutado antes de cada test)
    @BeforeEach
    void setUp() {
        // Creamos un animal antes de cada prueba
        animal = new Animal("León", TipoAnimal.TERRESTRE, "rugido");
    }

    // Test para verificar que el animal se ha creado correctamente
    @Test
    void testAnimalCreation() {
        assertNotNull(animal, "El animal no debe ser nulo");
        assertEquals("León", animal.getNombre(), "El nombre del animal debe ser León");
        assertEquals(TipoAnimal.TERRESTRE, animal.getTipo(), "El tipo de animal debe ser TERRESTRE");
        assertEquals("rugido", animal.getOnomatopeya(), "La onomatopeya debe ser rugido");
    }

    // Test para filtrar por tipo
    @Test
    void testFiltrarPorTipo() {
        // Creamos una lista de animales para probar el filtrado
        List<Animal> animales = List.of(
                new Animal("León", TipoAnimal.TERRESTRE, "rugido"),
                new Animal("Águila", TipoAnimal.VOLADOR, "caw"),
                new Animal("Pez", TipoAnimal.ACUATICO, "glub")
        );

        // Filtramos por tipo TERRESTRE
        List<Animal> filtrados = animales.stream()
                .filter(animal -> animal.getTipo() == TipoAnimal.TERRESTRE)
                .collect(Collectors.toList());

        assertEquals(1, filtrados.size(), "Debe haber 1 animal de tipo TERRESTRE");
        assertEquals("León", filtrados.get(0).getNombre(), "El animal filtrado debe ser León");
    }
}
