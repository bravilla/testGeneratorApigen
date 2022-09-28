package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostAlumnosInputMapper extends JapiAbstractCustomMapper<PostAlumnosInputDTO, Alumno> {
    public Alumno dtoToEntity(PostAlumnosInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Alumno entity = new Alumno();
        // TODO-JAPI: No se ha podido mapear el campo nombreAlumno. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo apellido1. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo apellido2. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        if (dto.getNif() != null) {
            entity.setNif(dto.getNif());
        }
        // TODO-JAPI: No se ha podido mapear el campo fechaNacimiento. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo idDireccionAlumno. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo idDireccionTutor. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        return entity;
    }
}
