package org.madrid.japi.rest.ejemplo.alumnos.status;

import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.ResponseMessages;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.javaapi.responses.swagger.NotAuthorizedResponse;
import org.madrid.japi.javaapi.responses.swagger.NotFoundResponse;
import org.madrid.japi.javaapi.responses.swagger.WithoutPermissionsResponse;
import org.madrid.japi.javaapi.status.StatusDTO;
import org.madrid.japi.javaapi.status.StatusService;
import org.madrid.japi.javaapi.status.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Este recurso no puede ser eliminado porque siempre los Servicios REST
 * deben tener un recurso /status al menos y uno por cada versión del API
 *
 * Puede ser modificada la forma de rellenar el StatusDTO
 * La forma estándar será extender statusService y sobreescribir el método
 * getStatus() llamando siempre al super()
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@RestController
@RequestMapping(value= {"/status","/v1/status"})
public class StatusController {

    /**
     * Servicio que rellena el statusDTO con información de
     * la aplicación y su estado
     */
    @Autowired
    private StatusService statusService;

    /**
     * Recurso status
     * @return Json con información de la app
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
            @ApiResponse(code=200, message="Server UP", response=StatusResponse.class),
            @ApiResponse(code=401, message=ResponseMessages.CODE_401, response=NotAuthorizedResponse.class),
            @ApiResponse(code=403, message=ResponseMessages.CODE_403, response=WithoutPermissionsResponse.class),
            @ApiResponse(code=404, message=ResponseMessages.CODE_404, response=NotFoundResponse.class)
            })
    public StandardResponse<StatusDTO> status() {
        return ResponseBuilder.with(HttpStatus.OK, true, statusService.getStatus(true), "Server UP");
    }
}