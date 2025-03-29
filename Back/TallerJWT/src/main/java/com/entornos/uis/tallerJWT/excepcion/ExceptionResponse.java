package com.entornos.uis.tallerJWT.excepcion;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author roa
 */
@Schema(description = "Estructura de respuesta para errores")
public class ExceptionResponse {
    @Schema(description = "Fecha y hora del error")
    private Date timestamp;
    
    @Schema(description = "Mensaje de error")
    private String mensaje;
    
    @Schema(description = "Detalles adicionales del error")
    private String detalles;
    
    @Schema(description = "Errores de validación", example = "{'campo': 'mensaje de error'}")
    private Map<String, String> erroresValidacion;

    public ExceptionResponse() {
        
    }

    public ExceptionResponse(Date timestamp, String mensaje, String detalles) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public ExceptionResponse(Date timestamp, String mensaje, String detalles, Map<String, String> erroresValidacion) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.erroresValidacion = erroresValidacion;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Map<String, String> getErroresValidacion() {
        return erroresValidacion;
    }

    public void setErroresValidacion(Map<String, String> erroresValidacion) {
        this.erroresValidacion = erroresValidacion;
    }
}
