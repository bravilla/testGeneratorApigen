package org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;
import org.madrid.japi.javaapi.dto.scan.JapiFieldClass;
import org.madrid.japi.javaapi.model.BodyFilterParameter;

/**
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 * DTO de entrada para el objeto de dominio: <code>{@link Alumno}</code><br/>
 */
@Data
@JapiFieldClass
public class PostAlumnosInputDTO extends BodyFilterParameter {
    /**
     * Campo nombreAlumno para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("nombre_alumno")
    @JapiField(
            entityFieldName = "nombreAlumno",
            entityType = String.class
    )
    private String nombreAlumno;

    /**
     * Campo apellido1 para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("apellido_1")
    @JapiField(
            entityFieldName = "apellido1",
            entityType = String.class
    )
    private String apellido1;

    /**
     * Campo apellido2 para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("apellido_2")
    @JapiField(
            entityFieldName = "apellido2",
            entityType = String.class
    )
    private String apellido2;

    /**
     * Campo nif para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("nif")
    @JapiField(
            entityFieldName = "nif",
            entityType = String.class
    )
    private String nif;

    /**
     * Campo fechaNacimiento para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("fecha_nacimiento")
    @JapiField(
            entityFieldName = "fechaNacimiento",
            entityType = String.class
    )
    private String fechaNacimiento;

    /**
     * Campo idDireccionAlumno para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("id_direccion_alumno")
    @JapiField(
            entityFieldName = "idDireccionAlumno",
            entityType = Long.class
    )
    private Long idDireccionAlumno;

    /**
     * Campo idDireccionTutor para el DTO de entrada del objeto de dominio alumno
     */
    @JsonProperty("id_direccion_tutor")
    @JapiField(
            entityFieldName = "idDireccionTutor",
            entityType = Long.class
    )
    private Long idDireccionTutor;
}
