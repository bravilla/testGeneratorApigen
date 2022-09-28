package org.madrid.japi.rest.ejemplo.alumnos.solicitud.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostSolicitudesBecasInputMapper extends JapiAbstractCustomMapper<PostSolicitudesBecasInputDTO, Solicitud> {
    public Solicitud dtoToEntity(PostSolicitudesBecasInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Solicitud entity = new Solicitud();
        // TODO-JAPI: No se ha podido mapear el campo idAlumno. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo fechaSolicitud. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        if (dto.getTipoSolicitud() != null) {
            entity.setTipoSolicitud(dto.getTipoSolicitud());
        }
        if (dto.getObservaciones() != null) {
            entity.setObservaciones(dto.getObservaciones());
        }
        return entity;
    }
}
