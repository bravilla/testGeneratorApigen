package org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.core8.util.CoreDateUtils;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetAlumnosUuidAlumnoOutputMapper extends JapiAbstractCustomMapper<GetAlumnosUuidAlumnoOutputDTO, Alumno> {
    public GetAlumnosUuidAlumnoOutputDTO entityToDto(Alumno entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetAlumnosUuidAlumnoOutputDTO dto = new GetAlumnosUuidAlumnoOutputDTO();
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
