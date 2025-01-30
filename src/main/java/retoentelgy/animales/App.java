package retoentelgy.animales;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // Lista para guardar los animales
        List<Animal> animales = new ArrayList<>();
        Set<String> animalesNombres = new HashSet<>();  // Para evitar duplicados

        // Verificar si se pasan argumentos
        if (args.length == 0) {
            System.out.println("Por favor, proporciona los datos del animal en el formato: nombre|tipo|onomatopeya");
            return;
        }

        // Procesar los argumentos (por ejemplo, "lobo|terrestre|auuu")
        String input = args[0];
        String[] data = input.split("\\|");

        if (data.length != 3) {
            System.out.println("Entrada incorrecta. Debe ser: nombre|tipo|onomatopeya");
            return;
        }

        String nombre = data[0];
        String tipo = data[1];
        String onomatopeya = data[2];

        // Si el animal ya existe, no lo agregamos
        if (animalesNombres.contains(nombre)) {
            System.out.println("El animal " + nombre + " ya ha sido creado previamente.");
            return;
        }

        // Crear el objeto Animal
        Animal animal = new Animal(nombre, tipo, onomatopeya);

        // Agregar el animal a la lista y al conjunto de nombres para evitar duplicados
        animales.add(animal);
        animalesNombres.add(nombre);

        // Mostrar la información del animal creado
        System.out.println("Animal creado: " + animal);

        // Guardar los animales en un archivo JSON
        Gson gson = new Gson();
        File file = new File("animales.json");

        // Si el archivo existe, leemos los datos existentes
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type animalListType = new TypeToken<List<Animal>>() {}.getType();
                List<Animal> existingAnimals = gson.fromJson(reader, animalListType);
                animales.addAll(existingAnimals);  // Añadimos los animales existentes
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Escribir la lista de animales (nuevos y existentes) en el archivo JSON
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(animales, writer);
            System.out.println("\nAnimales guardados en 'animales.json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}