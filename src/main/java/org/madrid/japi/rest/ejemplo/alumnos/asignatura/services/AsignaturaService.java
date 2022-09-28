package org.madrid.japi.rest.ejemplo.alumnos.asignatura.services;

import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dao.AsignaturaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.GetAsignaturasIdAsignaturaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetOutputDTO;

public interface AsignaturaService extends BaseService<Asignatura, Long, AsignaturaDAO> {
    GetAsignaturasIdAsignaturaOutputDTO getAsignaturasIdAsignatura(Long idAsignatura,
            Set<String> select, Set<String> exclude, Set<String> expand) throws ServiceException,
            JapiException;

    PostAsignaturasGetOutputDTO postAsignaturasGet(PostAsignaturasGetInputDTO inputDTO) throws
            ServiceException, JapiException;
}
