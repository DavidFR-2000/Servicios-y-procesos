package capturasalidaproceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CapturaSalidaProceso {

  public static void main(String[] args) {
    // Verifica si se proporciona al menos un argumento en línea de comandos.
    if (args.length < 1) {
      System.out.println("ERROR: indicar directorio");
      System.exit(1); // Sale del programa con un código de error 1.
    }

    String nomDir = args[0]; // Obtiene el primer argumento como directorio.

    File f = new File(nomDir);
    // Verifica si el argumento especificado es un directorio válido.
    if (!f.isDirectory()) {
      System.out.printf("ERROR: No existe directorio %s\n", nomDir);
      System.exit(2); // Sale del programa con un código de error 2.
    }

    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", "/w", nomDir);
    try {
      Process p = pb.start(); // Inicia un proceso que ejecuta "ls -lF" en el directorio especificado.
      // La siguiente es una alternativa a ProcessBuilder
      // Process p = Runtime.getRuntime().exec(new String[] {"ls", "-lF", nomDir});
      p.waitFor(); // Espera a que el proceso termine su ejecución.

      try (InputStream is = p.getInputStream();
           InputStreamReader isr = new InputStreamReader(is);
           BufferedReader br = new BufferedReader(isr)) {
        int numLin = 1; // Inicializa el número de línea.
        String linea = null;
        // Lee y muestra línea por línea la salida del proceso.
        while ((linea = br.readLine()) != null) {
          System.out.printf("%d: %s\n", numLin++, linea);
        }
      }
    } catch (IOException e) {
      e.printStackTrace(); // Maneja excepciones de E/S (IOException).
    } catch (InterruptedException ex) {
      // Maneja excepciones de interrupción (InterruptedException).
      // Puede dejar este bloque vacío, no se realiza ninguna acción específica en caso de interrupción.
    }
  }
}