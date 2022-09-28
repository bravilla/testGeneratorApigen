package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.domain.SolicitudAdjunto;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dtos.PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputMapper extends JapiAbstractCustomMapper<PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputDTO, SolicitudAdjunto> {
    public PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputDTO entityToDto(
            SolicitudAdjunto entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputDTO dto = new PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputDTO();
        if (entity.getIdAdjunto() != null) {
            dto.setIdAdjunto(entity.getIdAdjunto());
        }
        if (entity.getIdSolicitud() != null) {
            dto.setIdSolicitud(entity.getIdSolicitud().getIdSolicitud());
        }
        if (entity.getIdFica() != null) {
            dto.setIdFica(entity.getIdFica());
        }
        if (entity.getNombreFichero() != null) {
            dto.setNombreFichero(entity.getNombreFichero());
        }
        if (entity.getTamanoBytes() != null) {
            dto.setTamanoBytes(entity.getTamanoBytes());
        }
        return dto;
    }
}
