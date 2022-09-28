package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.search.JapiPaginatedSearchResult;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.javaapi.responses.metadata.StandardPaging;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.services.AlumnoService;
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
@RequestMapping("/asignaturas/{id_asignatura}/alumnos/")
@Validated
public class AsignaturasAlumnosV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private AlumnoService alumnoservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    /**
     * mÃ©todo GetAll del controlador REST para el objeto de dominio: Alumno
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id_asignatura}/alumnos"
    )
    @ResponseStatus(
            code = HttpStatus.PARTIAL_CONTENT
    )
    @ApiOperation(
            value = "getAll",
            notes = "DescripciÃ³n de getAll",
            tags = "Alumnoes (consultas)"
    )
    public StandardResponse<GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO> getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnos(
            @PathVariable("id_asignatura") Long idAsignatura,
            @RequestParam(value = "$init", required = false, defaultValue = "0") @ApiParam(name = "$init", value = "Indica el Ã­ndice de comienzo en la paginaciÃ³n") Integer init,
            @RequestParam(value = "$limit", required = false) @ApiParam(name = "$limit", value = "Indica el Ã­ndice final en la paginaciÃ³n") Integer limit,
            @RequestParam(value = "$total", required = false) @ApiParam(name = "$total", value = "Indica si hay que obtener y mostrar el total de elementos encontrados") Boolean total,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y aÃ±adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica quÃ© propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica quÃ© propiedades no se han de aÃ±adir a la respuesta") Set<String> exclude,
            @RequestParam(value = "$orderby", required = false) @ApiParam(name = "$orderby", value = "Indica mediante quÃ© propiedad se debe realizar la ordenaciÃ³n y cÃ³mo") List<String> orderby)
            throws ServiceException {
        String additionalParams = StandardPaging.buildPaginationLinkAdditionalParams(total, expand, select, exclude, orderby);

        // Si no se ha especificado un lÃ­mite de elementos en la paginaciÃ³n se asigna el especificado por defecto
        if (limit == null) {
            limit = limitDefaultValue;
        }
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el resultado de la bÃºsqueda ya mapeado
        JapiPaginatedSearchResult<GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO> paginatedResult = this.alumnoservice.getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnos(idAsignatura, select, exclude, expand, orderby, init, limit, total);

        // Construye el objeto de metadatos de la paginaciÃ³n devuelto en la respuesta, construye la respuesta completa y la devuelve
        StandardPaging paginationMetadata = StandardPaging.buildPaginationMetadata(init, limit, paginatedResult.getTotalElements(), "\"{id_asignatura}/alumnos\"", additionalParams);
        return ResponseBuilder.withPaginationMetadata(HttpStatus.PARTIAL_CONTENT, true, paginatedResult.getSingleSearchResult(), SUCCESSFUL_RESPONSE_MESSAGE, paginationMetadata);
    }
}
