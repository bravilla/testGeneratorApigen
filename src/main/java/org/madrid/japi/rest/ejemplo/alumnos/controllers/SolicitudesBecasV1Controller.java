package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.GetSolicitudesBecasIdSolicitudBecaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.services.SolicitudService;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.validators.PostSolicitudesBecasValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/solicitudes-becas/")
@Validated
public class SolicitudesBecasV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private SolicitudService solicitudservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    @Autowired
    private PostSolicitudesBecasValidator postSolicitudesBecasValidator;

    /**
     * mÃ©todo create del controlador REST para el objeto de dominio: Solicitud
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.CREATED
    )
    @ApiOperation(
            value = "create",
            notes = "DescripciÃ³n de create",
            tags = "Solicitudes (modificaciÃ³n)"
    )
    public StandardResponse<PostSolicitudesBecasOutputDTO> postSolicitudesBecas(
            @RequestBody PostSolicitudesBecasInputDTO objectToCreate) throws ServiceException {
        postSolicitudesBecasValidator.doValidate(objectToCreate);
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el objeto resultado de la creaciÃ³n ya mapeado
        PostSolicitudesBecasOutputDTO outputDTO = this.solicitudservice.postSolicitudesBecas(objectToCreate);

        // Construye y devuelve el objeto de respuesta
        return ResponseBuilder.with(HttpStatus.CREATED, true, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * mÃ©todo getById del controlador REST para el objeto de dominio: Solicitud
     */
    @GetMapping(
            value = "{id_solicitud_beca}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "getById",
            notes = "DescripciÃ³n de getById",
            tags = "Solicitudes (consultas)"
    )
    public StandardResponse<GetSolicitudesBecasIdSolicitudBecaOutputDTO> getSolicitudesBecasIdSolicitudBeca(
            @PathVariable("id_solicitud_beca") Long idSolicitudBeca,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y aÃ±adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica quÃ© propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica quÃ© propiedades no se han de aÃ±adir a la respuesta") Set<String> exclude)
            throws ServiceException {
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el resultado de la bÃºsqueda ya mapeado
        GetSolicitudesBecasIdSolicitudBecaOutputDTO outputDto = this.solicitudservice.getSolicitudesBecasIdSolicitudBeca(idSolicitudBeca, select, exclude, expand);

        // Construye la respuesta y la devuelve
        return ResponseBuilder.with(HttpStatus.OK, true, outputDto, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
