package dto;

public class etiquetasDTO {

    private Long idEtiqueta;
    private String nombre;

    public etiquetasDTO() {
    }

    public etiquetasDTO(Long idEtiqueta, String nombre) {
        this.idEtiqueta = idEtiqueta;
        this.nombre = nombre;
    }

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EtiquetasDTO{" +
                "idEtiqueta=" + idEtiqueta +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
