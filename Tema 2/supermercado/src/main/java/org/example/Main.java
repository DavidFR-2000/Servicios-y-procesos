package org.example;

public class Main {
    public static void main(String[] args){
        Cliente cliente = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        Caja caj1 = new Caja("Pedro");
        Caja caj2 = new Caja("Pedro");


        long tiempoInicial = System.currentTimeMillis();
        caj1.procesarCompra(cliente, tiempoInicial);
        caj2.procesarCompra(cliente2, tiempoInicial);

        //Hilos

        Thread cajh1 = new Caja2("Pedro", cliente, tiempoInicial);
        Thread cajh2 = new Caja2("Ana", cliente2, tiempoInicial);

        cajh1.start();
        cajh2.start();
    }
}
