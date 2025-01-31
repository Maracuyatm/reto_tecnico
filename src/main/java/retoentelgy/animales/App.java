package retoentelgy.animales;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Lista para guardar los animales
        List<Animal> animales = new ArrayList<>();

        // Verificar si se pasan argumentos
        if (args.length == 0) {
            System.out.println("Por favor, proporciona los datos del animal en el formato: nombre|tipo|onomatopeya");
            return;
        }

        // Procesar los argumentos (por ejemplo, "pato|volador|cuak")
        String input = args[0];
        String[] data = input.split("\\|");

        if (data.length != 3) {
            System.out.println("Entrada incorrecta. Debe ser: nombre|tipo|onomatopeya");
            return;
        }

        String nombre = data[0];
        String tipoString = data[1];  // El tipo ahora será un String
        String onomatopeya = data[2];

        // Convertir el tipo de String a TipoAnimal
        TipoAnimal tipo = TipoAnimal.valueOf(tipoString.toUpperCase()); // Convertimos el tipo a enum

        // Crear el objeto Animal
        Animal animal = new Animal(nombre, tipo, onomatopeya);

        // Llamar explícitamente a los métodos de las interfaces
        animal.respirar();  // Esto debería mostrar "Respirando..."
        animal.digerir();   // Esto debería mostrar "Digerir alimentos..."
        animal.tipoDesplazamiento();  // Esto debería mostrar el tipo de desplazamiento según el animal

        // Agregar el animal a la lista
        animales.add(animal);

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
