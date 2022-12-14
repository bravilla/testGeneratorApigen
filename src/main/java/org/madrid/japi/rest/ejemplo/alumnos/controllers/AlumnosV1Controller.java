package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.search.JapiPaginatedSearchResult;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.ResponseKeyValue;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.javaapi.responses.metadata.StandardPaging;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PutAlumnosUuidAlumnoInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PutAlumnosUuidAlumnoOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.services.AlumnoService;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosGetValidator;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosValidator;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PutAlumnosUuidAlumnoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Slf4j
@RestController
@RequestMapping("/alumnos/")
@Validated
public class AlumnosV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private AlumnoService alumnoservice;

    /**
     * Valor por defecto para limit, le????do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    @Autowired
    private PutAlumnosUuidAlumnoValidator putAlumnosUuidAlumnoValidator;

    @Autowired
    private PostAlumnosValidator postAlumnosValidator;

    @Autowired
    private PostAlumnosGetValidator postAlumnosGetValidator;

    /**
     * m????todo getById del controlador REST para el objeto de dominio: Alumno
     */
    @GetMapping(
            value = "{uuid_alumno}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "getById",
            notes = "Descripci????n de getById",
            tags = "Alumnoes (consultas)"
    )
    public StandardResponse<GetAlumnosUuidAlumnoOutputDTO> getAlumnosUuidAlumno(
            @PathVariable("uuid_alumno") @Size(max = 40) String uuidAlumno,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y a????adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica qu???? propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica qu???? propiedades no se han de a????adir a la respuesta") Set<String> exclude)
            throws ServiceException {
        // Se llama al m????todo asociado en el servicio, que devuelve el resultado de la b????squeda ya mapeado
        GetAlumnosUuidAlumnoOutputDTO outputDto = this.alumnoservice.getAlumnosUuidAlumno(uuidAlumno, select, exclude, expand);

        // Construye la respuesta y la devuelve
        return ResponseBuilder.with(HttpStatus.OK, true, outputDto, SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * m????todo update del controlador REST para el objeto de dominio: Alumno
     */
    @PutMapping(
            value = "{uuid_alumno}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "update",
            notes = "Descripci????n de update",
            tags = "Alumnoes (modificaci????n)"
    )
    public StandardResponse<PutAlumnosUuidAlumnoOutputDTO> putAlumnosUuidAlumno(
            @PathVariable("uuid_alumno") @Size(max = 40) String uuidAlumno,
            @RequestBody PutAlumnosUuidAlumnoInputDTO objectToUpdate,
            ContentCachingRequestWrapper request) throws IOException, JapiException,
            ServiceException {
        putAlumnosUuidAlumnoValidator.doValidate(objectToUpdate);
        // Se llama al m????todo asociado en el servicio, que devuelve el objeto resultado de la creaci????n ya mapeado
        PutAlumnosUuidAlumnoOutputDTO outputDTO = this.alumnoservice.putAlumnosUuidAlumno(uuidAlumno, objectToUpdate, request);

        // Construye el objeto de respuesta y lo devuelve
        return ResponseBuilder.withUpdatedElements(HttpStatus.OK, true, 1, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * m????todo delete del controlador REST para el objeto de dominio: Alumno
     */
    @DeleteMapping(
            value = "{uuid_alumno}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "deleteById",
            notes = "Descripci????n de deleteById",
            tags = "Alumnoes (modificaci????n)"
    )
    public StandardResponse<ResponseKeyValue> deleteAlumnosUuidAlumno(
            @PathVariable("uuid_alumno") @Size(max = 40) String uuidAlumno) throws
            ServiceException {
        // Se llama al m????todo de borrado en el servicio. De ser borrado l????gico, la distinci????n se hace ah????.
        this.alumnoservice.deleteAlumnosUuidAlumno(uuidAlumno);

        // Construye y devuelve el objeto de respuesta si no ha habido error borrando el registro
        return ResponseBuilder.withUpdatedElements(HttpStatus.OK, true, 1, new ResponseKeyValue("id_alumno", uuidAlumno), SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * m????todo GetAll del controlador REST para el objeto de dominio: Alumno
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.PARTIAL_CONTENT
    )
    @ApiOperation(
            value = "getAll",
            notes = "Descripci????n de getAll",
            tags = "Alumnoes (consultas)"
    )
    public StandardResponse<GetAlumnosOutputDTO> getAlumnos(
            @RequestParam(value = "$init", required = false, defaultValue = "0") @ApiParam(name = "$init", value = "Indica el ????ndice de comienzo en la paginaci????n") Integer init,
            @RequestParam(value = "$limit", required = false) @ApiParam(name = "$limit", value = "Indica el ????ndice final en la paginaci????n") Integer limit,
            @RequestParam(value = "$total", required = false) @ApiParam(name = "$total", value = "Indica si hay que obtener y mostrar el total de elementos encontrados") Boolean total,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y a????adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica qu???? propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica qu???? propiedades no se han de a????adir a la respuesta") Set<String> exclude,
            @RequestParam(value = "$orderby", required = false) @ApiParam(name = "$orderby", value = "Indica mediante qu???? propiedad se debe realizar la ordenaci????n y c????mo") List<String> orderby)
            throws ServiceException {
        String additionalParams = StandardPaging.buildPaginationLinkAdditionalParams(total, expand, select, exclude, orderby);

        // Si no se ha especificado un l????mite de elementos en la paginaci????n se asigna el especificado por defecto
        if (limit == null) {
            limit = limitDefaultValue;
        }
        // Se llama al m????todo asociado en el servicio, que devuelve el resultado de la b????squeda ya mapeado
        JapiPaginatedSearchResult<GetAlumnosOutputDTO> paginatedResult = this.alumnoservice.getAlumnos(select, exclude, expand, orderby, init, limit, total);

        // Construye el objeto de metadatos de la paginaci????n devuelto en la respuesta, construye la respuesta completa y la devuelve
        StandardPaging paginationMetadata = StandardPaging.buildPaginationMetadata(init, limit, paginatedResult.getTotalElements(), null, additionalParams);
        return ResponseBuilder.withPaginationMetadata(HttpStatus.PARTIAL_CONTENT, true, paginatedResult.getSingleSearchResult(), SUCCESSFUL_RESPONSE_MESSAGE, paginationMetadata);
    }

    /**
     * m????todo create del controlador REST para el objeto de dominio: Alumno
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
            notes = "Descripci????n de create",
            tags = "Alumnoes (modificaci????n)"
    )
    public StandardResponse<PostAlumnosOutputDTO> postAlumnos(
            @RequestBody PostAlumnosInputDTO objectToCreate) throws ServiceException {
        postAlumnosValidator.doValidate(objectToCreate);
        // Se llama al m????todo asociado en el servicio, que devuelve el objeto resultado de la creaci????n ya mapeado
        PostAlumnosOutputDTO outputDTO = this.alumnoservice.postAlumnos(objectToCreate);

        // Construye y devuelve el objeto de respuesta
        return ResponseBuilder.with(HttpStatus.CREATED, true, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }

    /**
     * m????todo create del controlador REST para el objeto de dominio: Alumno
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
            notes = "Descripci????n de create",
            tags = "Alumnoes (modificaci????n)"
    )
    public StandardResponse<PostAlumnosGetOutputDTO> postAlumnosGet(
            @RequestBody PostAlumnosGetInputDTO objectToCreate) throws ServiceException {
        postAlumnosGetValidator.doValidate(objectToCreate);
        // Se llama al m????todo asociado en el servicio, que devuelve el objeto resultado de la creaci????n ya mapeado
        PostAlumnosGetOutputDTO outputDTO = this.alumnoservice.postAlumnosGet(objectToCreate);

        // Construye y devuelve el objeto de respuesta
        return ResponseBuilder.with(HttpStatus.CREATED, true, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
