package org.example;


// Se ejecutan de manera alternativa los metodos get y put
class Contenedor<T> {
    private T dato;



    public T get() throws InterruptedException {
        // Genera una variable resultado.
        T result;
        // Los hilos hacen de manera sincronizada a la clase dada (contenedor)
        synchronized (this) {
//          Mientras que el resultado del metodo datoDisponible sea False, hace que los hilos esperen
            while (!this.datoDisponible()) {
                this.wait();
            }
//          Cuando datoDisponible devuelva True, guardas el valor en resultado, pones la variable dato a nula y
//          notificas al los hilos que esten "wait" para que revisen si esta disponible el dato.
            result = this.dato;
            this.dato = null;
            this.notifyAll();
        }
//        Devolvemos result
        return result;
    }

    public void put(T valor) throws InterruptedException {
//      Le pasas por parametro un valor.
//      Los hilos acceden de manera sincronizada a la instancia de la clase (Contenedor en este caso)
        synchronized (this) {
//            Mientras que el resultado del metodo datoDisponible sea False, hace que los hilos esperen
            while (this.datoDisponible()) {
                this.wait();
            }
//            La variable dato obtiene el valor que se ha pasado al metodo
            this.dato = valor;
//            Se notifica a los hilos
            this.notifyAll();
        }
    }

    synchronized boolean datoDisponible() {
        return (this.dato != null);
    }
}
