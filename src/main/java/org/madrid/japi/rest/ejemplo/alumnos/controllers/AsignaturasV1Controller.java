package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.GetAsignaturasIdAsignaturaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.services.AsignaturaService;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.validators.PostAsignaturasGetValidator;
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
@RequestMapping("/asignaturas/")
@Validated
public class AsignaturasV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private AsignaturaService asignaturaservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    @Autowired
    private PostAsignaturasGetValidator postAsignaturasGetValidator;

    /**
     * mÃ©todo getById del controlador REST para el objeto de dominio: Asignatura
     */
    @GetMapping(
            value = "{id_asignatura}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "getById",
            notes = "DescripciÃ³n de getById",
            tags = "Asignaturas (consultas)"
    )
    public StandardResponse<GetAsignaturasIdAsignaturaOutputDTO> getAsignaturasIdAsignatura(
            @PathVariable("id_asignatura") Long idAsignatura,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y aÃ±adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica quÃ© propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica quÃ© propiedades no se han de aÃ±adir a la respuesta") Set<String> exclude)
            throws ServiceException {
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el resultado de la bÃºsqueda ya mapeado
        GetAsignaturasIdAsignaturaOutputDTO outputDto = this.asignaturaservice.getAsignaturasIdAsignatura(idAsignatura, select, exclude, expand);

        // Construye la respuesta y la devuelve
        return ResponseBuilder.with(HttpStatus.OK, true, outputDto, SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * mÃ©todo create del controlador REST para el objeto de dominio: Asignatura
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
            tags = "Asignaturas (modificaciÃ³n)"
    )
    public StandardResponse<PostAsignaturasGetOutputDTO> postAsignaturasGet(
            @RequestBody PostAsignaturasGetInputDTO objectToCreate) throws ServiceException {
        postAsignaturasGetValidator.doValidate(objectToCreate);
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el objeto resultado de la creaciÃ³n ya mapeado
        PostAsignaturasGetOutputDTO outputDTO = this.asignaturaservice.postAsignaturasGet(objectToCreate);

        // Construye y devuelve el objeto de respuesta
        return ResponseBuilder.with(HttpStatus.CREATED, true, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
