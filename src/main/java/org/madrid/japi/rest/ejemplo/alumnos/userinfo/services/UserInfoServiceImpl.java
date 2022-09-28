package org.madrid.japi.rest.ejemplo.alumnos.userinfo.services;

import java.util.Map;

import org.madrid.japi.rest.ejemplo.alumnos.userinfo.dtos.UserInfoDto;
import org.madrid.japi.javaapi.security.userdata.UserUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * Servicio para el recurso /user-info
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Service("userInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService {


    /**
     * Devuelve los datos del usuario en un DTO para el recurso /user-info
     */
    @Override
    public UserInfoDto getUserInfo() {
        UserInfoDto userInfoDto = new UserInfoDto();

        // Obtener datos básicos
        userInfoDto.setUserName(UserUtils.getUserName());
        userInfoDto.setNif(UserUtils.getUserNif());

        // Obtener roles
        for (GrantedAuthority grantedAuthority : UserUtils.getUserRoles()) {
            String rol = grantedAuthority.getAuthority();
            userInfoDto.getRoles().add(rol);
        }

        // Obtener userDetails
        Map<String, String> map = UserUtils.getUserDetails();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            userInfoDto.addUserDetail(entry.getKey(), entry.getValue());
        }

        return userInfoDto;
    }
}
