package org.example;

import java.util.concurrent.Semaphore;

public class LanzaHilos6 {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);

        Thread hilo = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    semaforo.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);

                semaforo.release();
            }
        });

        hilo.start();
    }
}

    //Este ejercicio crea un hilo que imprime los números del 0 al 100, uno por línea. El programa utiliza la clase Semaphore para controlar el acceso a la salida estándar. Esto garantiza que solo un hilo a la vez pueda imprimir un número.

    //    La salida del programa es la siguiente:

    //    0
    //    1
    //    2
    //    ...
    //    100
