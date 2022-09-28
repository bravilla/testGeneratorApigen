package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.services.AlumnoService;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosResumenGetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/alumnos-resumen/")
@Validated
public class AlumnosResumenV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private AlumnoService alumnoservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    @Autowired
    private PostAlumnosResumenGetValidator postAlumnosResumenGetValidator;

    /**
     * mÃ©todo create del controlador REST para el objeto de dominio: Alumno
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
            tags = "Alumnoes (modificaciÃ³n)"
    )
    public StandardResponse<PostAlumnosResumenGetOutputDTO> postAlumnosResumenGet(
            @RequestParam(value = "id_asignatura", required = false) Integer idAsignatura,
            @RequestParam(value = "cd_prov_municpio", required = false) @Size(max = 5) String cdProvMunicpio,
            @RequestBody PostAlumnosResumenGetInputDTO objectToCreate) throws ServiceException {
        postAlumnosResumenGetValidator.doValidate(objectToCreate);
        // Se llama al mÃ©todo asociado en el servicio, que devuelve el objeto resultado de la creaciÃ³n ya mapeado
        PostAlumnosResumenGetOutputDTO outputDTO = this.alumnoservice.postAlumnosResumenGet(objectToCreate);

        // Construye y devuelve el objeto de respuesta
        return ResponseBuilder.with(HttpStatus.CREATED, true, outputDTO, SUCCESSFUL_RESPONSE_MESSAGE);
    }
}
