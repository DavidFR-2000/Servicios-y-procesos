public class Hilo implements Runnable {
    private final String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.printf("Hola soy el hilo %s.\n", nombre);
        System.out.printf("Hilo %s finalizado.\n", nombre);
    }
}
