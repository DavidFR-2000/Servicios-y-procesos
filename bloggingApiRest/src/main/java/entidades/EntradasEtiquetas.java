package entidades;

import javax.persistence.*;
import java.io.Serializable;

public class EntradasEtiquetas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntradaEtiqueta;

    @ManyToMany
    @JoinColumn(name = "entrada_id")
    private entradas entrada;

    @ManyToMany
    @JoinColumn(name = "etiqueta_id")
    private etiquetas etiqueta;

    public EntradasEtiquetas() {
    }

    public EntradasEtiquetas(Long idEntradaEtiqueta, entradas entrada, etiquetas etiqueta) {
        this.idEntradaEtiqueta = idEntradaEtiqueta;
        this.entrada = entrada;
        this.etiqueta = etiqueta;
    }

    public Long getIdEntradaEtiqueta() {
        return idEntradaEtiqueta;
    }

    public void setIdEntradaEtiqueta(Long idEntradaEtiqueta) {
        this.idEntradaEtiqueta = idEntradaEtiqueta;
    }

    public entradas getEntrada() {
        return entrada;
    }

    public void setEntrada(entradas entrada) {
        this.entrada = entrada;
    }

    public etiquetas getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(etiquetas etiqueta) {
        this.etiqueta = etiqueta;
    }
}
