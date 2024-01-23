package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LanzaHilos7 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread hilo = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                lock.lock();

                try {
                    System.out.println(i);
                } finally {
                    lock.unlock();
                }
            }
        });

        hilo.start();
    }
}

    //Este ejercicio es similar al ejercicio 10, pero utiliza la clase Lock para controlar el acceso a la salida estándar. Esto garantiza que solo un hilo a la vez pueda imprimir un número.

    //    La salida del programa es la misma que la salida del ejercicio 10:

    //    0
    //    1
    //    2
    //    ...
     //   100