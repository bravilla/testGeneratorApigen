package org.madrid.japi.rest.ejemplo.alumnos.municipio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link Municipio}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO {
    /**
     * Campo cdProvincia para el DTO de salida del objeto de dominio municipio
     */
    @JsonProperty("id_provincia")
    @JapiField(
            entityFieldName = "cdProvincia",
            entityType = String.class
    )
    private String idProvincia;

    /**
     * Campo cdMunicipio para el DTO de salida del objeto de dominio municipio
     */
    @JsonProperty("id_municipio")
    @JapiField(
            entityFieldName = "cdMunicipio",
            entityType = String.class
    )
    private String idMunicipio;

    /**
     * Campo dsMunicipio para el DTO de salida del objeto de dominio municipio
     */
    @JsonProperty("municipio")
    @JapiField(
            entityFieldName = "dsMunicipio",
            entityType = String.class
    )
    private String municipio;
}
