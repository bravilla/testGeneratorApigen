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
public class PostAlumnosOutputDTO {
    /**
     * Campo idAlumno para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("id")
    @JapiField(
            isId = true,
            entityFieldName = "idAlumno"
    )
    private Long id;

    /**
     * Campo uuid para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("uuid")
    @JapiField(
            entityFieldName = "uuid",
            entityType = String.class
    )
    private String uuid;

    /**
     * Campo dsNombre para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("nombre_alumno")
    @JapiField(
            entityFieldName = "dsNombre",
            entityType = String.class
    )
    private String nombreAlumno;

    /**
     * Campo dsApellido1 para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("apellido_1")
    @JapiField(
            entityFieldName = "dsApellido1",
            entityType = String.class
    )
    private String apellido1;

    /**
     * Campo dsApellido2 para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("apellido_2")
    @JapiField(
            entityFieldName = "dsApellido2",
            entityType = String.class
    )
    private String apellido2;

    /**
     * Campo nif para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("nif")
    @JapiField(
            entityFieldName = "nif",
            entityType = String.class
    )
    private String nif;

    /**
     * Campo fcNacimiento para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("fecha_nacimiento")
    @JapiField(
            entityFieldName = "fcNacimiento",
            entityType = String.class
    )
    private String fechaNacimiento;

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
     * Campo numeroAsignaturasAprobadas para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("numero_asignaturas_aprobadas")
    @JapiField(
            entityFieldName = "numeroAsignaturasAprobadas",
            entityType = Long.class
    )
    private Long numeroAsignaturasAprobadas;

    /**
     * Campo direccionAlumno para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("direccion_alumno")
    @JapiField(
            entityFieldName = "direccionAlumno",
            entityType = Object.class
    )
    private Object direccionAlumno;

    /**
     * Campo direccionTutor para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("direccion_tutor")
    @JapiField(
            entityFieldName = "direccionTutor",
            entityType = Object.class
    )
    private Object direccionTutor;
}
