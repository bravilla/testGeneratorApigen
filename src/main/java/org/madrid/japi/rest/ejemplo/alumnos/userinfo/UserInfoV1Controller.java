package org.madrid.japi.rest.ejemplo.alumnos.userinfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.madrid.japi.rest.ejemplo.alumnos.userinfo.dtos.UserInfoDto;
import org.madrid.japi.rest.ejemplo.alumnos.userinfo.services.UserInfoService;
import org.madrid.japi.rest.ejemplo.alumnos.userinfo.doc.GetUserInfoResponse;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.responses.ResponseBuilder;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.madrid.japi.javaapi.responses.swagger.BadRequestResponse;
import org.madrid.japi.javaapi.responses.swagger.NotAuthorizedResponse;
import org.madrid.japi.javaapi.responses.swagger.NotFoundResponse;
import org.madrid.japi.javaapi.responses.swagger.WithoutPermissionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.madrid.japi.javaapi.responses.ResponseMessages;

/**
 * Controlador REST para el obtener la información del usuario identificado que realiza la llamada.
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Api(tags = {"Información del usuario" })
@RestController
@RequestMapping("/v1/user-info")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserInfoV1Controller {
    /**
     * Referencia al servicio UserInfoService
     */
    @Autowired
    private UserInfoService userInfoService;

    /**
     * Método Get /userInfo
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Respuesta correcta", response = GetUserInfoResponse.class),
            @ApiResponse(code = 400, message = ResponseMessages.CODE_400, response = BadRequestResponse.class),
            @ApiResponse(code = 401, message = ResponseMessages.CODE_401, response = NotAuthorizedResponse.class),
            @ApiResponse(code = 403, message = ResponseMessages.CODE_403, response = WithoutPermissionsResponse.class),
            @ApiResponse(code = 404, message = ResponseMessages.CODE_404, response = NotFoundResponse.class) })
    @ApiOperation(value = "Información del usuario", notes = "Obtiene información del usuario conectado basada en el token JWT", tags = "Información del usuario")
    public StandardResponse<UserInfoDto> getUserInfo() throws ServiceException {

        // Llamar al negocio para obtener los datos en un dto
        UserInfoDto userInfo = userInfoService.getUserInfo();
        return ResponseBuilder.with(HttpStatus.OK, true, userInfo, "Respuesta correcta");
    }
}

