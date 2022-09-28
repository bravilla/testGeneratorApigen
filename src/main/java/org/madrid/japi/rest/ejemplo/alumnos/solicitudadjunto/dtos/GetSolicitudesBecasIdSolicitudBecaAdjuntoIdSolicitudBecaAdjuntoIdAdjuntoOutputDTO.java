package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.madrid.japi.javaapi.dto.scan.JapiField;

/**
 * DTO de salida para el objeto de dominio: <code>{@link SolicitudAdjunto}</code><br/>
 *
 * @author Generador de API Rest (v1.0.0)
 * @since 28-sep-2022 16:05:10
 */
@Data
public class GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO {
    /**
     * Campo idAdjunto para el DTO de salida del objeto de dominio solicitudadjunto
     */
    @JsonProperty("id_adjunto")
    @JapiField(
            isId = true,
            entityFieldName = "idAdjunto"
    )
    private Long idAdjunto;

    /**
     * Campo idSolicitud para el DTO de salida del objeto de dominio solicitudadjunto
     */
    @JsonProperty("id_solicitud")
    @JapiField(
            entityFieldName = "idSolicitud",
            entityType = Long.class
    )
    private Long idSolicitud;

    /**
     * Campo idFica para el DTO de salida del objeto de dominio solicitudadjunto
     */
    @JsonProperty("id_fica")
    @JapiField(
            entityFieldName = "idFica",
            entityType = String.class
    )
    private String idFica;

    /**
     * Campo nombreFichero para el DTO de salida del objeto de dominio solicitudadjunto
     */
    @JsonProperty("nombre_fichero")
    @JapiField(
            entityFieldName = "nombreFichero",
            entityType = String.class
    )
    private String nombreFichero;

    /**
     * Campo tamanoBytes para el DTO de salida del objeto de dominio solicitudadjunto
     */
    @JsonProperty("tamano_bytes")
    @JapiField(
            entityFieldName = "tamanoBytes",
            entityType = Long.class
    )
    private Long tamanoBytes;
}
