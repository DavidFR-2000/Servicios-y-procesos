package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // Crear los tenedores
        Semaphore[] tenedores = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Semaphore(1);
        }

        // Crear los filósofos
        for (int i = 0; i < 5; i++) {
            Filosofo filosofo = new Filosofo(i, tenedores);
            filosofo.start();
        }
    }
}