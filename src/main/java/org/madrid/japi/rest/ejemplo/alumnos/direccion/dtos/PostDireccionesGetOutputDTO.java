package org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Direccion}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class PostDireccionesGetOutputDTO {
    /**
     * Campo direcciones para el DTO de salida del objeto de dominio direccion
     */
    @JsonProperty("direcciones")
    @JapiField(
            entityType = org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion.class,
            isEntity = true
    )
    private List<DireccionesOutputDTO> direcciones;

    /**
     * DTO de salida para el objeto de dominio: <code>{@link Direccion}</code><br/>
     *
     * @author Generador de API Rest (v1.0.0)
     * @since 28-sep-2022 16:05:10
     */
    @Data
    public static class DireccionesOutputDTO {
        /**
         * Campo idDireccion para el DTO de salida del objeto de dominio direccion
         */
        @JsonProperty("id_direccion")
        @JapiField(
                isId = true,
                entityFieldName = "idDireccion"
        )
        private Long idDireccion;

        /**
         * Campo provincia para el DTO de salida del objeto de dominio direccion
         */
        @JsonProperty("provincia")
        @JapiField(
                entityFieldName = "provincia",
                entityType = String.class
        )
        private String provincia;

        /**
         * Campo municipio para el DTO de salida del objeto de dominio direccion
         */
        @JsonProperty("municipio")
        @JapiField(
                entityFieldName = "municipio",
                entityType = String.class
        )
        private String municipio;

        /**
         * Campo calle para el DTO de salida del objeto de dominio direccion
         */
        @JsonProperty("calle")
        @JapiField(
                entityFieldName = "calle",
                entityType = String.class
        )
        private String calle;

        /**
         * Campo numero para el DTO de salida del objeto de dominio direccion
         */
        @JsonProperty("numero")
        @JapiField(
                entityFieldName = "numero",
                entityType = Long.class
        )
        private Long numero;
    }
}
