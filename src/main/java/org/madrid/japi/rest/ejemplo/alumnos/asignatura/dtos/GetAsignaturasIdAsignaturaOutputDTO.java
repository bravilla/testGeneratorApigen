package org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Asignatura}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class GetAsignaturasIdAsignaturaOutputDTO {
    /**
     * Campo idAsignatura para el DTO de salida del objeto de dominio asignatura
     */
    @JsonProperty("id_asignatura")
    @JapiField(
            isId = true,
            entityFieldName = "idAsignatura"
    )
    private Long idAsignatura;

    /**
     * Campo dsAsignatura para el DTO de salida del objeto de dominio asignatura
     */
    @JsonProperty("nombre_asignatura")
    @JapiField(
            entityFieldName = "dsAsignatura",
            entityType = String.class
    )
    private String nombreAsignatura;

    /**
     * Campo nmCurso para el DTO de salida del objeto de dominio asignatura
     */
    @JsonProperty("curso")
    @JapiField(
            entityFieldName = "nmCurso",
            entityType = String.class
    )
    private String curso;

    /**
     * Campo profesor para el DTO de salida del objeto de dominio asignatura
     */
    @JsonProperty("profesor")
    @JapiField(
            entityFieldName = "profesor",
            entityType = Object.class
    )
    private Object profesor;
}
