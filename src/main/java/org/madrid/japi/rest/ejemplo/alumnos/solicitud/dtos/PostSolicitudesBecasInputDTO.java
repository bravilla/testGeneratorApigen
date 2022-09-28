package org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;
import org.madrid.japi.javaapi.dto.scan.JapiFieldClass;
import org.madrid.japi.javaapi.model.BodyFilterParameter;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;

/**
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 * DTO de entrada para el objeto de dominio: <code>{@link Solicitud}</code><br/>
 */
@Data
@JapiFieldClass
public class PostSolicitudesBecasInputDTO extends BodyFilterParameter {
    /**
     * Campo idAlumno para el DTO de entrada del objeto de dominio solicitud
     */
    @JsonProperty("id_alumno")
    @JapiField(
            entityType = Alumno.class,
            entityFieldName = "idAlumno",
            isEntity = true
    )
    private Long idAlumno;

    /**
     * Campo fechaSolicitud para el DTO de entrada del objeto de dominio solicitud
     */
    @JsonProperty("fecha_solicitud")
    @JapiField(
            entityFieldName = "fechaSolicitud",
            entityType = String.class
    )
    private String fechaSolicitud;

    /**
     * Campo tipoSolicitud para el DTO de entrada del objeto de dominio solicitud
     */
    @JsonProperty("tipo_solicitud")
    @JapiField(
            entityFieldName = "tipoSolicitud",
            entityType = String.class
    )
    private String tipoSolicitud;

    /**
     * Campo observaciones para el DTO de entrada del objeto de dominio solicitud
     */
    @JsonProperty("observaciones")
    @JapiField(
            entityFieldName = "observaciones",
            entityType = String.class
    )
    private String observaciones;
}
