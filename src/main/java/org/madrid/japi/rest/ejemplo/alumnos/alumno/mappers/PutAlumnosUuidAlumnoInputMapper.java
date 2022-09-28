package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PutAlumnosUuidAlumnoInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PutAlumnosUuidAlumnoInputMapper extends JapiAbstractCustomMapper<PutAlumnosUuidAlumnoInputDTO, Alumno> {
    public Alumno dtoToEntity(PutAlumnosUuidAlumnoInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Alumno entity = new Alumno();
        // TODO-JAPI: No se ha podido mapear el campo nombreAlumno. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo apellido1. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo apellido2. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo fechaNacimiento. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo idDireccion. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        // TODO-JAPI: No se ha podido mapear el campo asignaturasIds. Se recibe un tipo bÃ¡sico y en la entidad es un tipo relacionado, por lo que no se conoce con quÃ© campo del tipo relacionado estÃ¡ relacionado. Incluir aquÃ­ la bÃºsqueda del campo a partir del dato que se recibe.

        return entity;
    }
}
