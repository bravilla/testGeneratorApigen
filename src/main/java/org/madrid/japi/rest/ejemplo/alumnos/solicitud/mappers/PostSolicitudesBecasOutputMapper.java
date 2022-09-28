package org.madrid.japi.rest.ejemplo.alumnos.solicitud.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostSolicitudesBecasOutputMapper extends JapiAbstractCustomMapper<PostSolicitudesBecasOutputDTO, Solicitud> {
    public PostSolicitudesBecasOutputDTO entityToDto(Solicitud entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        PostSolicitudesBecasOutputDTO dto = new PostSolicitudesBecasOutputDTO();
        if (entity.getIdSolicitud() != null) {
            dto.setIdSolicitud(entity.getIdSolicitud());
        }
        if (entity.getIdAlumno() != null) {
            dto.setIdAlumno(entity.getIdAlumno().getIdAlumno());
        }
        if (entity.getNifPresentante() != null) {
            dto.setNifPresentante(entity.getNifPresentante());
        }
        if (entity.getTipoSolicitud() != null) {
            dto.setTipoSolicitud(entity.getTipoSolicitud());
        }
        if (entity.getObservaciones() != null) {
            dto.setObservaciones(entity.getObservaciones());
        }
        return dto;
    }
}
