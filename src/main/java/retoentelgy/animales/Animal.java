package retoentelgy.animales;

public class Animal {
    private String nombre;
    private String tipo;
    private String onomatopeya;

    // Constructor
    public Animal(String nombre, String tipo, String onomatopeya) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.onomatopeya = onomatopeya;
    }

    // Métodos para determinar el tipo del animal
    public boolean esTerrestre() {
        return "terrestre".equalsIgnoreCase(tipo);
    }

    public boolean esVolador() {
        return "volador".equalsIgnoreCase(tipo);
    }

    public boolean esAcuatico() {
        return "acuático".equalsIgnoreCase(tipo);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getOnomatopeya() {
        return onomatopeya;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setOnomatopeya(String onomatopeya) {
        this.onomatopeya = onomatopeya;
    }

    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + ", tipo=" + tipo + ", onomatopeya=" + onomatopeya + "]";
    }
}
