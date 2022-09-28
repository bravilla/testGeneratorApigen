package org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class GetAlumnosOutputDTO {
    /**
     * Campo alumnos para el DTO de salida del objeto de dominio alumno
     */
    @JsonProperty("alumnos")
    @JapiField(
            entityType = org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno.class,
            isEntity = true
    )
    private List<AlumnosOutputDTO> alumnos;

    /**
     * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
     *
     * @author Generador de API Rest (v1.0.0)
     * @since 28-sep-2022 16:05:10
     */
    @Data
    public static class AlumnosOutputDTO {
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
                entityType = Direccion.class,
                entityFieldName = "direccionAlumno",
                isEntity = true
        )
        private DireccionAlumnoOutputDTO direccionAlumno;

        /**
         * Campo direccionTutor para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("direccion_tutor")
        @JapiField(
                entityFieldName = "direccionTutor",
                entityType = Object.class
        )
        private Object direccionTutor;

        /**
         * Campo asignaturas para el DTO de salida del objeto de dominio alumno
         */
        @JsonProperty("asignaturas")
        private List<AsignaturasOutputDTO> asignaturas;

        /**
         * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
         *
         * @author Generador de API Rest (v1.0.0)
         * @since 28-sep-2022 16:05:10
         */
        @Data
        public static class DireccionAlumnoOutputDTO {
            /**
             * Campo idDireccion para el DTO de salida del objeto de dominio alumno
             */
            @JsonProperty("id_direccion")
            @JapiField(
                    entityFieldName = "direccionAlumno.idDireccion",
                    entityType = Long.class
            )
            private Long idDireccion;

            /**
             * Campo provincia para el DTO de salida del objeto de dominio alumno
             */
            @JsonProperty("provincia")
            @JapiField(
                    entityFieldName = "direccionAlumno.provincia",
                    entityType = String.class
            )
            private String provincia;

            /**
             * Campo municipio para el DTO de salida del objeto de dominio alumno
             */
            @JsonProperty("municipio")
            @JapiField(
                    entityFieldName = "direccionAlumno.municipio",
                    entityType = String.class
            )
            private String municipio;

            /**
             * Campo calle para el DTO de salida del objeto de dominio alumno
             */
            @JsonProperty("calle")
            @JapiField(
                    entityFieldName = "direccionAlumno.calle",
                    entityType = String.class
            )
            private String calle;

            /**
             * Campo numero para el DTO de salida del objeto de dominio alumno
             */
            @JsonProperty("numero")
            @JapiField(
                    entityFieldName = "direccionAlumno.numero",
                    entityType = Long.class
            )
            private Long numero;
        }

        /**
         * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
         *
         * @author Generador de API Rest (v1.0.0)
         * @since 28-sep-2022 16:05:10
         */
        @Data
        public static class DireccionTutorOutputDTO {
        }

        /**
         * DTO de salida para el objeto de dominio: <code>{@link Alumno}</code><br/>
         *
         * @author Generador de API Rest (v1.0.0)
         * @since 28-sep-2022 16:05:10
         */
        @Data
        public static class AsignaturasOutputDTO {
        }
    }
}
