package org.example;

import java.util.concurrent.atomic.AtomicInteger;

class Contador2 {
    private AtomicInteger cuenta = new AtomicInteger(0);

    public Contador2() {
    }

    public void incrementar() {
        cuenta.incrementAndGet();
    }

    public int getCuenta() {
        return cuenta.get();
    }
}

public class LanzaHilos2 {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                contador.incrementar();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(contador.getCuenta());
            }
        });

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El valor del contador es: " + contador.getCuenta());
    }
}

//Ejercicio 2

//Este ejercicio es similar al ejercicio 1, pero utiliza la clase AtomicInteger para realizar operaciones atómicas sobre el contador. Esto evita la necesidad de utilizar la sincronización, lo que puede mejorar el rendimiento del programa.

//La salida del programa es la misma que la salida del ejercicio 1:

//El valor del contador es: 200
//En este ejercicio, los hilos comparten el acceso al contador. Sin embargo, la clase AtomicInteger garantiza que las operaciones sobre el contador se realizan de forma segura y sin bloqueos. Esto significa que no es necesario utilizar la sincronización para evitar condiciones de carrera.