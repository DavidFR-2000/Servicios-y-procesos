package org.example;
import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable {

    private int id;
    private Semaphore[] tenedores;

    public Filosofo(int id, Semaphore[] tenedores) {
        this.id = id;
        this.tenedores = tenedores;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            cogerTenedores();
            comer();
            soltarTenedores();
        }
    }

    private void pensar() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cogerTenedores() {
        // Solicitar el tenedor izquierdo
        if (!tenedores[id].tryAcquire()) {
            // El tenedor izquierdo no está disponible
            return;
        }

        // Solicitar el tenedor derecho
        if (!tenedores[(id + 1) % 5].tryAcquire()) {
            // El tenedor derecho no está disponible
            tenedores[id].release();
            return;
        }
    }

    private void comer() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void soltarTenedores() {
        // Liberar el tenedor derecho
        tenedores[(id + 1) % 5].release();

        // Liberar el tenedor izquierdo
        tenedores[id].release();
    }


}
