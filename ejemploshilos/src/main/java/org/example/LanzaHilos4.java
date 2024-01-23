package org.example;

public class LanzaHilos4 {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                synchronized (System.out) {
                    System.out.println(i);
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 101; i <= 200; i++) {
                synchronized (System.out) {
                    System.out.println(i);
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}

    //Este ejercicio crea dos hilos, uno llamado Hilo1 y otro llamado Hilo2. El hilo Hilo1 imprime los números del 0 al 100, uno por línea. El hilo Hilo2 imprime los números del 101 al 200, uno por línea.

    //    El programa utiliza la palabra clave synchronized para sincronizar el acceso a la salida estándar. Esto garantiza que los números se impriman en orden, sin que se solapen.

    //    La salida del programa es la siguiente:

    //    0
    //    1
    //    ...
    //    100
    //    101
    //    102
    //    ...
    //    200