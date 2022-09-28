package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.services;

import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dao.SolicitudAdjuntoDAO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.domain.SolicitudAdjunto;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dtos.GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO;

public interface SolicitudAdjuntoService extends BaseService<SolicitudAdjunto, Long, SolicitudAdjuntoDAO> {
    GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO getSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjunto(
            Long idSolicitudBeca, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException;
}
