package org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Solicitud}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class PostSolicitudesBecasOutputDTO {
    /**
     * Campo idSolicitud para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("id_solicitud")
    @JapiField(
            isId = true,
            entityFieldName = "idSolicitud"
    )
    private Long idSolicitud;

    /**
     * Campo idAlumno para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("id_alumno")
    @JapiField(
            entityFieldName = "idAlumno",
            entityType = Long.class
    )
    private Long idAlumno;

    /**
     * Campo fechaSolicitud para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("fecha_solicitud")
    @JapiField(
            entityFieldName = "fechaSolicitud",
            entityType = String.class
    )
    private String fechaSolicitud;

    /**
     * Campo nifPresentante para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("nif_presentante")
    @JapiField(
            entityFieldName = "nifPresentante",
            entityType = String.class
    )
    private String nifPresentante;

    /**
     * Campo tipoSolicitud para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("tipo_solicitud")
    @JapiField(
            entityFieldName = "tipoSolicitud",
            entityType = String.class
    )
    private String tipoSolicitud;

    /**
     * Campo observaciones para el DTO de salida del objeto de dominio solicitud
     */
    @JsonProperty("observaciones")
    @JapiField(
            entityFieldName = "observaciones",
            entityType = String.class
    )
    private String observaciones;
}
