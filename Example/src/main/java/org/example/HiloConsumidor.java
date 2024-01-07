package org.example;

import java.util.Random;

class HiloConsumidor implements Runnable{
    final Contenedor<Integer> cont;
    String miNombre;

    HiloConsumidor(Contenedor<Integer> cont, String miNombre){
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run(){
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(10 + r.nextInt(50 - 10 + 1));
                Integer dato = this.cont.get();
                long numSec = Secuencia.getNumSec();
                System.out.printf("%d-Hilo %s produce valor %s.\n",
                        numSec, this.miNombre, dato);

            }catch (InterruptedException ex){

            }
        }
    }
}
