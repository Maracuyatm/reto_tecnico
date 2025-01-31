package retoentelgy.animales;

public class Animal implements SistemaDigestivo, SistemaRespiratorio {
    private String nombre;
    private TipoAnimal tipo;
    private String onomatopeya;

    public Animal(String nombre, TipoAnimal tipo, String onomatopeya) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.onomatopeya = onomatopeya;
    }

    // Implementación de los métodos de la interfaz SistemaRespiratorio
    @Override
    public void respirar() {
        System.out.println("Respirando...");
    }

    // Implementación de los métodos de la interfaz SistemaDigestivo
    @Override
    public void digerir() {
        System.out.println("Digerir alimentos...");
    }

    // Método tipoDesplazamiento basado en el tipo de animal
    public void tipoDesplazamiento() {
        switch (this.tipo) {
            case TERRESTRE:
                System.out.println(nombre + " camina o corre.");
                break;
            case VOLADOR:
                System.out.println(nombre + " vuela o planea.");
                break;
            case ACUATICO:
                System.out.println(nombre + " nada o bucea.");
                break;
            default:
                System.out.println(nombre + " no tiene un tipo de desplazamiento conocido.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public String getOnomatopeya() {
        return onomatopeya;
    }

    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + ", tipo=" + tipo + ", onomatopeya=" + onomatopeya + "]";
    }
}
