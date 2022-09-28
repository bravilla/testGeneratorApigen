package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.madrid.core8.util.CoreDateUtils;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputMapper extends JapiAbstractCustomMapper<GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO, Alumno> {
    private AlumnosOutputMapper alumnosOutputMapper = new AlumnosOutputMapper();

    public GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO entityToDto(
            List<Alumno> entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO dto = new GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO();
        dto.setAlumnos(new ArrayList<>());
        for (Alumno entityElement : entity) {
            dto.getAlumnos().add(alumnosOutputMapper.entityToDto(entityElement));
        }
        return dto;
    }

    public class AlumnosOutputMapper {
        public GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO.AlumnosOutputDTO entityToDto(
                Alumno entity) {
            Assert.notNull(entity, "El parÃ¡metro entity es nulo");
            GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO.AlumnosOutputDTO dto = new GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO.AlumnosOutputDTO();
            if (entity.getIdAlumno() != null) {
                dto.setId(entity.getIdAlumno());
            }
            if (entity.getUuid() != null) {
                dto.setUuid(entity.getUuid());
            }
            if (entity.getDsNombre() != null) {
                dto.setNombreAlumno(entity.getDsNombre());
            }
            if (entity.getDsApellido1() != null) {
                dto.setApellido1(entity.getDsApellido1());
            }
            if (entity.getDsApellido2() != null) {
                dto.setApellido2(entity.getDsApellido2());
            }
            if (entity.getNif() != null) {
                dto.setNif(entity.getNif());
            }
            if (entity.getFcNacimiento() != null) {
                dto.setFechaNacimiento(CoreDateUtils.LOCAL_DATE_TIME_ISO8601_CONVERTER.dateToString(entity.getFcNacimiento()));
            }
            return dto;
        }
    }
}
