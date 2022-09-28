package org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.GetAsignaturasIdAsignaturaOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetAsignaturasIdAsignaturaOutputMapper extends JapiAbstractCustomMapper<GetAsignaturasIdAsignaturaOutputDTO, Asignatura> {
    public GetAsignaturasIdAsignaturaOutputDTO entityToDto(Asignatura entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetAsignaturasIdAsignaturaOutputDTO dto = new GetAsignaturasIdAsignaturaOutputDTO();
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
