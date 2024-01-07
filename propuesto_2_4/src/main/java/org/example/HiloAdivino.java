package org.example;

import java.util.Random;


public class HiloAdivino extends Thread {
    private NumeroOculto numeroOculto;

    HiloAdivino(NumeroOculto numeroOculto){
        this.numeroOculto = numeroOculto;
    }

    @Override
    public void run(){
        int intento;

        while (true){
            intento = new Random().nextInt(10);
            System.out.println("Hilo " + Thread.currentThread().getId() + " propone el numero: " + intento);

            int resultado = numeroOculto.propuestaNumero(intento);


            if (resultado == -1){
                System.out.println("Hilo " + Thread.currentThread().getId() + " el juego a terminado, ya han adivinado el numero");
                break;
            } else if (resultado == 1) {
                System.out.println("Hilo " + Thread.currentThread().getId() + " has adivinado el numero");
                break;
            }

            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
