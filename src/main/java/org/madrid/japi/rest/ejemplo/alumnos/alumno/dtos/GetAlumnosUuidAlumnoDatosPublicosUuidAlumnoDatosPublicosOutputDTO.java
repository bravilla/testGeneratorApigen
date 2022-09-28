package org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO {
    /**
     * Campo nombreAlumno para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("nombre_alumno")
    @JapiField(
            entityFieldName = "nombreAlumno",
            entityType = String.class
    )
    private String nombreAlumno;

    /**
     * Campo apellido1 para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("apellido_1")
    @JapiField(
            entityFieldName = "apellido1",
            entityType = String.class
    )
    private String apellido1;

    /**
     * Campo apellido2 para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("apellido_2")
    @JapiField(
            entityFieldName = "apellido2",
            entityType = String.class
    )
    private String apellido2;

    /**
     * Campo edad para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("edad")
    @JapiField(
            entityFieldName = "edad",
            entityType = Long.class
    )
    private Long edad;

    /**
     * Campo provincia para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("provincia")
    @JapiField(
            entityFieldName = "provincia",
            entityType = String.class
    )
    private String provincia;

    /**
     * Campo municipio para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("municipio")
    @JapiField(
            entityFieldName = "municipio",
            entityType = String.class
    )
    private String municipio;

    /**
     * Campo numeroAsignaturasAprobadas para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("numero_asignaturas_aprobadas")
    @JapiField(
            entityFieldName = "numeroAsignaturasAprobadas",
            entityType = Long.class
    )
    private Long numeroAsignaturasAprobadas;
}
