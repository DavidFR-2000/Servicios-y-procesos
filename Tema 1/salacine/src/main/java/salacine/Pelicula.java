package salacine;


import java.io.Serializable;

public class Pelicula implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;


    private String titulo,genero;
    private double recaudacion;
    private int duracion;

    public Pelicula(String titulo, String genero, double recaudacion, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.recaudacion = recaudacion;
        this.duracion = duracion;
    }

    public String getNombre() {
        return this.titulo;
    }

    public void setNombre(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getRecaudacion() {
        return this.recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public String toString(){
        String res="";
        
        res="-----------------------------\n"+
            "Nombre: "+this.titulo+"\n"+
            "Genero: "+this.genero+"\n"+
            "Duracion: "+this.duracion+" minutos\n"+
            "Recaudacion: "+this.recaudacion+" millones de dolares\n\n";
        
        return res;
    }
}
