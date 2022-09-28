package org.madrid.japi.rest.ejemplo.alumnos.municipio.mappers;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.model.mapper.JapiAbstractCustomMapper;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dtos.GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputMapper extends JapiAbstractCustomMapper<GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO, Municipio> {
    public GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO entityToDto(Municipio entity) {
        Assert.notNull(entity, "El parÃ¡metro entity es nulo");
        GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO dto = new GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO();
        if (entity.getDsMunicipio() != null) {
            dto.setMunicipio(entity.getDsMunicipio());
        }
        return dto;
    }
}
