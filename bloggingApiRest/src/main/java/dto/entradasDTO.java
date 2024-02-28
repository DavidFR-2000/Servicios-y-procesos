package dto;

public class entradasDTO {
    private Long idEntrada;
    private String titulo;
    private String contenido;
    private String fechaCreacion;
    private Long autorId;

    public entradasDTO() {
    }

    public entradasDTO(Long idEntrada, String titulo, String contenido, String fechaCreacion, Long autorId) {
        this.idEntrada = idEntrada;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.autorId = autorId;
    }

    public Long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Long idEntrada) {
        this.idEntrada = idEntrada;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString() {
        return "EntradasDTO{" +
                "idEntrada=" + idEntrada +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", autorId=" + autorId +
                '}';
    }
}

