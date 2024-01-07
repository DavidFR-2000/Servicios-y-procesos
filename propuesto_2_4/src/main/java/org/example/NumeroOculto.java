package org.example;

import java.util.Random;

public class NumeroOculto {
    private int numeroOculto;
    private boolean juegoTerminado;

    public NumeroOculto() {
        Random random = new Random();
        this.numeroOculto = random.nextInt(10); // Número aleatorio entre 0 y 9
        this.juegoTerminado = false;
    }

    public synchronized int propuestaNumero(int num) {
        if (juegoTerminado) {
            return -1; // El juego ya ha terminado
        }

        if (num == numeroOculto) {
            juegoTerminado = true;
            return 1; // Número adivinado correctamente
        }

        return 0; // El número no es el correcto
    }
}
