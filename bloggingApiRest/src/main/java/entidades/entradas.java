package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class entradas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrada;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "contenido")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private usuarios id_usuario;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    public entradas() {
    }

    public entradas(Long id_entrada, String titulo, String contenido, usuarios id_usuario, Date fecha_creacion) {
        this.id_entrada = id_entrada;
        this.titulo = titulo;
        this.contenido = contenido;
        this.id_usuario = id_usuario;
        this.fecha_creacion = fecha_creacion;
    }

    public Long getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Long id_entrada) {
        this.id_entrada = id_entrada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public usuarios getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(usuarios id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
