package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LanzaHilos5 {
    public static void main(String[] args) {
        CyclicBarrier barrera = new CyclicBarrier(2);

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    barrera.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 101; i <= 200; i++) {
                try {
                    barrera.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        });

        hilo1.start();
        hilo2.start();
    }
}

    //Este ejercicio es similar al ejercicio 7, pero utiliza la clase CyclicBarrier para sincronizar el acceso a la salida estándar. Esto garantiza que los números se impriman en orden, sin que se solapen.

    //    La salida del programa es la misma que la salida del ejercicio 7:

    //    0
    //    1
    //    ...
    //    100
    //    101
    //102
    //    ...
    //    200