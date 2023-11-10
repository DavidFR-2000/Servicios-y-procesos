import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int MAX_TIEMPO = 11;
    public static void main(String[] args) {
        if (args.length <=0)
        {
            System.out.println("No se ha indicado un comando");
            System.exit(1);
        }
        String[] comando = new String[]{"bash", "bucle.sh"};
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();
        try {
            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("La ejecucion e " + Arrays.toString(args) + "devuelve" + codRet);
        }catch (IOException e) {
            System.out.println("Error ejecutando el proceso");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceso interrunpido");
            System.exit(3);
        }
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

