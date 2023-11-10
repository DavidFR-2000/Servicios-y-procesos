import java.io.IOException;

public class Main {
    public static int MAX_TIEMPO = 11;
    public static void main(String[] args) {
        String[] comando = new String[]{"bash", "bucle.sh"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();
        try {
            Process p = pb.start();
            int i = 0;
            boolean fin = false;
            while (!fin) {
                System.out.printf("Verificación %d: ", i++);
                if (p.isAlive()) {
                    System.out.println("Proceso está vivo.");
                    Thread.sleep(3000);
                } else {
                    System.out.println("Proceso no está vivo.");
                    fin = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            e.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido");
        }
    }
}
