package org.example;

class Contador {
    private int cuenta = 0;

    public Contador() {
    }

    public synchronized void incrementar() {
        cuenta++;
    }

    public synchronized int getCuenta() {
        return cuenta;
    }
}

public class LanzaHilos {
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

    //Este ejercicio crea dos hilos, uno llamado Hilo1 y otro llamado Hilo2. El hilo Hilo1 incrementa el contador 100 veces, mientras que el hilo Hilo2 lee el valor del contador 100 veces.
    //El programa utiliza la palabra clave synchronized para sincronizar el acceso al método incrementar() del contador. Esto garantiza que solo un hilo a la vez tenga acceso al contador, lo que evita condiciones de carrera.
    //La salida del programa es la siguiente:
    //El valor del contador es: 200
    //En este ejercicio, los hilos comparten el acceso al contador. Si no se utiliza la sincronización, es posible que el resultado del programa sea incorrecto. Por ejemplo, es posible que el hilo Hilo2 lea un valor incorrecto del contador, ya que el hilo Hilo1 podría estar actualizando el valor del contador al mismo tiempo.
    //Para evitar este problema, se utiliza la sincronización para garantizar que solo un hilo a la vez tenga acceso al contador.
    //Esto garantiza que el valor del contador siempre sea correcto cuando el hilo Hilo2 lo lee.



