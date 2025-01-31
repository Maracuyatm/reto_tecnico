package retoentelgy.animales;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Inicializar Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lista para guardar los animales
        List<Animal> animales = new ArrayList<>();

        // Leer el archivo JSON si existe
        Gson gson = new Gson();
        File file = new File("animales.json");

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type animalListType = new TypeToken<List<Animal>>() {}.getType();
                animales = gson.fromJson(reader, animalListType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Verificar si se pasan argumentos
        if (args.length > 0) {
            String input = args[0];
        
            if (input.equalsIgnoreCase("filtrar") && args.length > 1) {
                // Filtrar animales por tipo
                try {
                    System.out.println("Filtrando por tipo: " + args[1]);  // Depuración aquí
                    
                    // Convertir el tipo a Enum (debe coincidir con el nombre del enum)
                    TipoAnimal tipoFiltro = TipoAnimal.valueOf(args[1].toUpperCase());
                    List<Animal> filtrados = animales.stream()
                            .filter(animal -> animal.getTipo() == tipoFiltro)
                            .collect(Collectors.toList());
        
                    // Mostrar los animales filtrados
                    System.out.println("\n Animales filtrados (" + tipoFiltro + "):");
                    filtrados.forEach(animal -> System.out.println(animal.getNombre() + " (" + animal.getOnomatopeya() + ")"));
        
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de animal no válido: " + args[1]);
                }
                return;  // Detener el proceso después de filtrar
            } else if (input.equalsIgnoreCase("filtrar")) {
                // Si no se pasa un tipo después de "filtrar"
                System.out.println("Debe proporcionar un tipo de animal para filtrar.");
                return;
            }
        
            // Verificar si la entrada es para crear un nuevo animal
            String[] data = input.split("\\|");
            if (data.length == 3) {
                try {
                    String nombre = data[0];
                    TipoAnimal tipo = TipoAnimal.valueOf(data[1].toUpperCase());
                    String onomatopeya = data[2];
        
                    // Crear el nuevo animal
                    Animal nuevoAnimal = new Animal(nombre, tipo, onomatopeya);
                    animales.add(nuevoAnimal);
        
                    // Guardar el animal en el archivo JSON
                    try (FileWriter writer = new FileWriter(file)) {
                        gson.toJson(animales, writer);
                        System.out.println("\n Nuevo animal agregado y guardado en 'animales.json'");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        
                    // Mostrar el nuevo animal creado
                    System.out.println("\n Animal creado: " + nuevoAnimal);
                    nuevoAnimal.respirar();
                    nuevoAnimal.digerir();
                    nuevoAnimal.tipoDesplazamiento();
        
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de animal no válido o formato incorrecto.");
                }
            } else {
                System.out.println("Entrada incorrecta. Debe ser: nombre|tipo|onomatopeya");
            }
        
        } else {
            // Si no hay argumentos, agrupar los animales por tipo
            Map<TipoAnimal, List<Animal>> animalesPorTipo = animales.stream()
                    .collect(Collectors.groupingBy(Animal::getTipo));
        
            System.out.println("\n🐾 Animales agrupados por tipo:");
            animalesPorTipo.forEach((tipo, listaAnimales) -> {
                System.out.println(tipo + ":");
                listaAnimales.forEach(animal -> System.out.println(" - " + animal.getNombre() + " (" + animal.getOnomatopeya() + ")"));
            });
        
            System.out.println("\n Para agregar un animal: mvn exec:java -Dexec.args=\"nombre|tipo|onomatopeya\"");
            System.out.println(" Para filtrar animales: mvn exec:java -Dexec.args=\"filtrar|tipo\"");
        }
        
        
    }
}
