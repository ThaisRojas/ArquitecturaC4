package ec.edu.arquitecturac4.backend.model;

import java.time.Instant;

public class LicenciaInfo {

    private final String cedula;
    private final String htmlRespuesta;
    private final Instant fechaActualizacion;

    public LicenciaInfo(String cedula, String htmlRespuesta, Instant fechaActualizacion) {
        this.cedula = cedula;
        this.htmlRespuesta = htmlRespuesta;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getHtmlRespuesta() {
        return htmlRespuesta;
    }

    public Instant getFechaActualizacion() {
        return fechaActualizacion;
    }
}