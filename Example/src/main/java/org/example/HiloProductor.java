package org.example;

import java.util.Random;

class HiloProductor implements Runnable {
    final Contenedor<Integer> cont;
    String miNombre;

    HiloProductor(Contenedor<Integer> cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run(){
        Random r = new Random();
        for (int i = 1;; i++){
            try{
                Thread.sleep(10 + r.nextInt(50 - 10 + 1 ));
                this.cont.put(i);
                long numSec = Secuencia.getNumSec();
                System.out.printf("%d-Hilo %s produce valor %s.\n",
                        numSec, this.miNombre, i);
            }catch (InterruptedException ex){

            }
        }
    }
}