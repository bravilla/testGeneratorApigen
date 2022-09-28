package org.madrid.japi.rest.ejemplo.alumnos.userinfo.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * DTO asociado al servicio de obtención de datos del usuario.
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Data
public class UserInfoDto {

    private String userName;
    private String nif;
    private List<String> roles =  new ArrayList<>();
    private List<UserDetail> userDetails =  new ArrayList<>();



    public void addUserDetail(String key, String value) {
        userDetails.add(new UserDetail(key,value));
    }

    @Data
    @AllArgsConstructor
    private class UserDetail {
        private String key;
        private String value;
    }

}

