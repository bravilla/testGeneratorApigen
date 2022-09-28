package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputMapper extends JapiAbstractCustomMapper<GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO, Alumno> {
    public GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO entityToDto(
            Alumno entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO dto = new GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO();
        return dto;
    }
}
