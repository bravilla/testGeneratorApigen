package org.madrid.japi.rest.ejemplo.alumnos.direccion.services;

import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dao.DireccionDAO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.GetDireccionesIdDireccionOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetOutputDTO;

public interface DireccionService extends BaseService<Direccion, Long, DireccionDAO> {
    GetDireccionesIdDireccionOutputDTO getDireccionesIdDireccion(Long idDireccion,
            Set<String> select, Set<String> exclude, Set<String> expand) throws ServiceException,
            JapiException;

    PostDireccionesGetOutputDTO postDireccionesGet(PostDireccionesGetInputDTO inputDTO) throws
            ServiceException, JapiException;
}
