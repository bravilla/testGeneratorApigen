package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Set;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.MunicipioEmbeddedId;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dtos.GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/municipios/{id_provincia}/")
@Validated
public class MunicipiosV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private MunicipioService municipioservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    private MunicipioEmbeddedId parseToEmbeddedId(String cdProvincia,
            String cdMunicipio) {
        MunicipioEmbeddedId embeddedId = new MunicipioEmbeddedId();
        embeddedId.setCdProvincia(cdProvincia);
        embeddedId.setCdMunicipio(cdMunicipio);
        return embeddedId;
    }

    /**
     * mÃ©todo getById del controlador REST para el objeto de dominio: Municipio
     */
    @GetMapping(
            value = "{id_provincia}/{id_municipio}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "getById",
            notes = "DescripciÃ³n de getById",
            tags = "Municipios (consultas)"
    )
    public StandardResponse<GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO> getMunicipiosIdProvinciaIdProvinciaIdMunicipio(
            @PathVariable("id_provincia") @Size(max = 2) String idProvincia,
            @PathVariable("id_municipio") @Size(max = 3) String idMunicipio,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y aÃ±adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica quÃ© propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica quÃ© propiedades no se han de aÃ±adir a la respuesta") Set<String> exclude)
            throws ServiceException {
        MunicipioEmbeddedId id = parseToEmbeddedId(idProvincia, idMunicipio);
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el resultado de la bÃºsqueda ya mapeado
        GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO outputDto = this.municipioservice.getMunicipiosIdProvinciaIdProvinciaIdMunicipio(id, select, exclude, expand);

        // Construye la respuesta y la devuelve
        return ResponseBuilder.with(HttpStatus.OK, true, outputDto, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
