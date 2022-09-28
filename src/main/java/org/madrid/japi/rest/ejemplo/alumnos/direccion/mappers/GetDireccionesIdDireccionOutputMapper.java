package org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.GetDireccionesIdDireccionOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetDireccionesIdDireccionOutputMapper extends JapiAbstractCustomMapper<GetDireccionesIdDireccionOutputDTO, Direccion> {
    public GetDireccionesIdDireccionOutputDTO entityToDto(Direccion entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetDireccionesIdDireccionOutputDTO dto = new GetDireccionesIdDireccionOutputDTO();
        if (entity.getIdDireccion() != null) {
            dto.setIdDireccion(entity.getIdDireccion());
        }
        return dto;
    }
}
