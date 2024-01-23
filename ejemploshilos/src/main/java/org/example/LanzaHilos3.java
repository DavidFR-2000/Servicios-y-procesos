package org.example;

public class LanzaHilos3 {
    public static void main(String[] args) {
        Thread hilo = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                synchronized (System.out) {
                    System.out.println(i);
                }
            }
        });

        hilo.start();
    }
}

    //Este ejercicio crea un hilo que imprime los números del 0 al 100, uno por línea. El programa utiliza la palabra clave synchronized para sincronizar el acceso a la salida estándar. Esto garantiza que los números se impriman en orden.

    //    La salida del programa es la siguiente:

    //    0
    //    1
    //    2
    //    ...
    //    100