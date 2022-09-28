package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO;
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
@RequestMapping("/alumnos/{uuid_alumno}/datos-publicos/")
@Validated
public class AlumnosDatosPublicosV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private AlumnoService alumnoservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    /**
     * mÃ©todo getById del controlador REST para el objeto de dominio: Alumno
     */
    @GetMapping(
            value = "{uuid_alumno}/datos-publicos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(
            code = HttpStatus.OK
    )
    @ApiOperation(
            value = "getById",
            notes = "DescripciÃ³n de getById",
            tags = "Alumnoes (consultas)"
    )
    public StandardResponse<GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO> getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicos(
            @PathVariable("uuid_alumno") String uuidAlumno,
            @RequestParam(value = "$expand", required = false) @ApiParam(name = "$expand", value = "Indica si se ha de expandir y aÃ±adir una propiedad relacionada") Set<String> expand,
            @RequestParam(value = "$select", required = false) @ApiParam(name = "$select", value = "Especifica quÃ© propiedades se han de recuperar, sean estas relacionadas o no") Set<String> select,
            @RequestParam(value = "$exclude", required = false) @ApiParam(name = "$exclude", value = "Especifica quÃ© propiedades no se han de aÃ±adir a la respuesta") Set<String> exclude)
            throws ServiceException {
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el resultado de la bÃºsqueda ya mapeado
        GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO outputDto = this.alumnoservice.getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicos(uuidAlumno, select, exclude, expand);

        // Construye la respuesta y la devuelve
        return ResponseBuilder.with(HttpStatus.OK, true, outputDto, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
