package org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostAsignaturasGetInputMapper extends JapiAbstractCustomMapper<PostAsignaturasGetInputDTO, Asignatura> {
    public Asignatura dtoToEntity(PostAsignaturasGetInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Asignatura entity = new Asignatura();
        return entity;
    }
}
