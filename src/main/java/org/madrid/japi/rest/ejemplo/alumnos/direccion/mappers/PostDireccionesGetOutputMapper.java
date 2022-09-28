package org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostDireccionesGetOutputMapper extends JapiAbstractCustomMapper<PostDireccionesGetOutputDTO, Direccion> {
    private DireccionesOutputMapper direccionesOutputMapper = new DireccionesOutputMapper();

    public PostDireccionesGetOutputDTO entityToDto(List<Direccion> entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        PostDireccionesGetOutputDTO dto = new PostDireccionesGetOutputDTO();
        dto.setDirecciones(new ArrayList<>());
        for (Direccion entityElement : entity) {
            dto.getDirecciones().add(direccionesOutputMapper.entityToDto(entityElement));
        }
        return dto;
    }

    public class DireccionesOutputMapper {
        public PostDireccionesGetOutputDTO.DireccionesOutputDTO entityToDto(Direccion entity) {
            Assert.notNull(entity, "El parÃ¡metro entity es nulo");
            PostDireccionesGetOutputDTO.DireccionesOutputDTO dto = new PostDireccionesGetOutputDTO.DireccionesOutputDTO();
            if (entity.getIdDireccion() != null) {
                dto.setIdDireccion(entity.getIdDireccion());
            }
            return dto;
        }
    }
}
