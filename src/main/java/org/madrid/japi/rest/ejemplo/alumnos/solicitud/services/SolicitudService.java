package org.madrid.japi.rest.ejemplo.alumnos.solicitud.services;

import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dao.SolicitudDAO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.GetSolicitudesBecasIdSolicitudBecaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasOutputDTO;

public interface SolicitudService extends BaseService<Solicitud, Long, SolicitudDAO> {
    PostSolicitudesBecasOutputDTO postSolicitudesBecas(PostSolicitudesBecasInputDTO inputDTO) throws
            ServiceException, JapiException;

    GetSolicitudesBecasIdSolicitudBecaOutputDTO getSolicitudesBecasIdSolicitudBeca(
            Long idSolicitudBeca, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException;
}
