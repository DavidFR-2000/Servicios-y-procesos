package dto;

public class EntradasEtiquetasDTO {
    private Long idEntradaEtiqueta;
    private Long entradaId;
    private Long etiquetaId;

    public EntradasEtiquetasDTO() {
    }

    public EntradasEtiquetasDTO(Long idEntradaEtiqueta, Long entradaId, Long etiquetaId) {
        this.idEntradaEtiqueta = idEntradaEtiqueta;
        this.entradaId = entradaId;
        this.etiquetaId = etiquetaId;
    }

    public Long getIdEntradaEtiqueta() {
        return idEntradaEtiqueta;
    }

    public void setIdEntradaEtiqueta(Long idEntradaEtiqueta) {
        this.idEntradaEtiqueta = idEntradaEtiqueta;
    }

    public Long getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Long entradaId) {
        this.entradaId = entradaId;
    }

    public Long getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(Long etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    @Override
    public String toString() {
        return "EntradasEtiquetasDTO{" +
                "idEntradaEtiqueta=" + idEntradaEtiqueta +
                ", entradaId=" + entradaId +
                ", etiquetaId=" + etiquetaId +
                '}';
    }
}
