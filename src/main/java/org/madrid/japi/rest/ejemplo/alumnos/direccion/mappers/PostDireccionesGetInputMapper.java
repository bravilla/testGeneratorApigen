package org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostDireccionesGetInputMapper extends JapiAbstractCustomMapper<PostDireccionesGetInputDTO, Direccion> {
    public Direccion dtoToEntity(PostDireccionesGetInputDTO dto) {
        Assert.notNull(dto, "El parÃ¡metro dto es nulo");
        Direccion entity = new Direccion();
        return entity;
    }
}
