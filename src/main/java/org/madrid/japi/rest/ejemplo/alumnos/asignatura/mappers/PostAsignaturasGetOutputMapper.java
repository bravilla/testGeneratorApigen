package org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostAsignaturasGetOutputMapper extends JapiAbstractCustomMapper<PostAsignaturasGetOutputDTO, Asignatura> {
    private AsignaturasOutputMapper asignaturasOutputMapper = new AsignaturasOutputMapper();

    public PostAsignaturasGetOutputDTO entityToDto(List<Asignatura> entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        PostAsignaturasGetOutputDTO dto = new PostAsignaturasGetOutputDTO();
        dto.setAsignaturas(new ArrayList<>());
        for (Asignatura entityElement : entity) {
            dto.getAsignaturas().add(asignaturasOutputMapper.entityToDto(entityElement));
        }
        return dto;
    }

    public class AsignaturasOutputMapper {
        public PostAsignaturasGetOutputDTO.AsignaturasOutputDTO entityToDto(Asignatura entity) {
            Assert.notNull(entity, "El parÃ¡metro entity es nulo");
            PostAsignaturasGetOutputDTO.AsignaturasOutputDTO dto = new PostAsignaturasGetOutputDTO.AsignaturasOutputDTO();
            if (entity.getIdAsignatura() != null) {
                dto.setIdAsignatura(entity.getIdAsignatura());
            }
            if (entity.getDsAsignatura() != null) {
                dto.setNombreAsignatura(entity.getDsAsignatura());
            }
            if (entity.getNmCurso() != null) {
                dto.setCurso(entity.getNmCurso());
            }
            return dto;
        }
    }
}
