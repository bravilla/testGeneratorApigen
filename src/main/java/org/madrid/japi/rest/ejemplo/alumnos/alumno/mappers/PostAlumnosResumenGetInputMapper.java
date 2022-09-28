package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostAlumnosResumenGetInputMapper extends JapiAbstractCustomMapper<PostAlumnosResumenGetInputDTO, Alumno> {
    public Alumno dtoToEntity(PostAlumnosResumenGetInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Alumno entity = new Alumno();
        return entity;
    }
}
