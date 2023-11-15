package org.example;


public class Main {
    public static void main(String[] args) {

        NumeroOculto numeroOculto = new NumeroOculto();

        for (int i = 0;i < 10; i++){
            Thread hilo = new HiloAdivino(numeroOculto);
            hilo.start();
        }
        }
    }
