package org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class PostAlumnosResumenGetOutputDTO {
    /**
     * Campo alumnosResumen para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("alumnos_resumen")
    @JapiField(
            entityType = org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno.class,
            isEntity = true
    )
    private List<AlumnosResumenOutputDTO> alumnosResumen;

    /**
     * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
     *
     * @author Generador de API Rest (v1.0.0)
     * @since 28-sep-2022 16:05:10
     */
    @Data
    public static class AlumnosResumenOutputDTO {
        /**
         * Campo cdProvMunicipio para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("cd_prov_municipio")
        @JapiField(
                entityFieldName = "cdProvMunicipio",
                entityType = String.class
        )
        private String cdProvMunicipio;

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
         * Campo idAsignatura para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("id_asignatura")
        @JapiField(
                entityFieldName = "idAsignatura",
                entityType = Long.class
        )
        private Long idAsignatura;

        /**
         * Campo nombreAsignatura para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("nombre_asignatura")
        @JapiField(
                entityFieldName = "nombreAsignatura",
                entityType = String.class
        )
        private String nombreAsignatura;

        /**
         * Campo annoNota para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("anno_nota")
        @JapiField(
                entityFieldName = "annoNota",
                entityType = Long.class
        )
        private Long annoNota;

        /**
         * Campo numeroPresentados para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("numero_presentados")
        @JapiField(
                entityFieldName = "numeroPresentados",
                entityType = Long.class
        )
        private Long numeroPresentados;

        /**
         * Campo numeroAprobados para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("numero_aprobados")
        @JapiField(
                entityFieldName = "numeroAprobados",
                entityType = Long.class
        )
        private Long numeroAprobados;

        /**
         * Campo numeroSuspendidos para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("numero_suspendidos")
        @JapiField(
                entityFieldName = "numeroSuspendidos",
                entityType = Long.class
        )
        private Long numeroSuspendidos;

        /**
         * Campo notaMedia para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("nota_media")
        private Object notaMedia;

        /**
         * Campo notaMaxima para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("nota_maxima")
        private Object notaMaxima;

        /**
         * Campo notaMinima para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("nota_minima")
        private Object notaMinima;
    }
}
