package org.madrid.japi.rest.ejemplo.alumnos.controllers;

import io.swagger.annotations.ApiOperation;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.responses.ResponseKeyValue;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.rest.ejemplo.alumnos.nota.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/alumnos/{uuid_alumno}/notas/")
@Validated
public class AlumnosNotasV1Controller {
    private static final String SUCCESSFUL_RESPONSE_MESSAGE = "Respuesta satisfactoria";

    @Autowired
    private NotaService notaservice;

    /**
     * Valor por defecto para limit, leÃ­do del fichero .properties empleado
     */
    @Value("${japi.rest.paginated-request-default-limit}")
    private Integer limitDefaultValue;

    @PostMapping(
            value = "{uuid_alumno}/notas",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(
            value = "Notas",
            notes = "DescripciÃ³n de Notas",
            tags = "Notas"
    )
    public StandardResponse<ResponseKeyValue> postAlumnosUuidAlumnoNotasUuidAlumnoNotas(
            @PathVariable("uuid_alumno") @Size(max = 40) String uuidAlumno) {

        // TODO-JAPI: Se ha intentado generar un mÃ©todo no reconocible como una operaciÃ³n CRUD.
        // Se crea con la definiciÃ³n especificada en el Swagger, pero deberÃ¡ cambiarse esta implementaciÃ³n.
        return null;
    }
}
