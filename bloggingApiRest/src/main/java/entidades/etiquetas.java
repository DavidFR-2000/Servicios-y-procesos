package entidades;

import javax.persistence.*;
import java.io.Serializable;

public class etiquetas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etiqueta;

    @Column(name = "nombre")
    private String nombre;


    public etiquetas() {
    }

    public etiquetas(Long id_etiqueta, String nombre) {
        this.id_etiqueta = id_etiqueta;
        this.nombre = nombre;
    }

    public Long getId_etiqueta() {
        return id_etiqueta;
    }

    public void setId_etiqueta(Long id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
