package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class PostAlumnosResumenGetOutputMapper extends JapiAbstractCustomMapper<PostAlumnosResumenGetOutputDTO, Alumno> {
    private AlumnosResumenOutputMapper alumnosResumenOutputMapper = new AlumnosResumenOutputMapper();

    public PostAlumnosResumenGetOutputDTO entityToDto(List<Alumno> entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        PostAlumnosResumenGetOutputDTO dto = new PostAlumnosResumenGetOutputDTO();
        dto.setAlumnosResumen(new ArrayList<>());
        for (Alumno entityElement : entity) {
            dto.getAlumnosResumen().add(alumnosResumenOutputMapper.entityToDto(entityElement));
        }
        return dto;
    }

    public class AlumnosResumenOutputMapper {
        public PostAlumnosResumenGetOutputDTO.AlumnosResumenOutputDTO entityToDto(Alumno entity) {
            Assert.notNull(entity, "El parÃ¡metro entity es nulo");
            PostAlumnosResumenGetOutputDTO.AlumnosResumenOutputDTO dto = new PostAlumnosResumenGetOutputDTO.AlumnosResumenOutputDTO();
            return dto;
        }
    }
}
