package org.madrid.japi.rest.ejemplo.alumnos.municipio.services;

import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dao.MunicipioDAO;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.MunicipioEmbeddedId;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dtos.GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO;

public interface MunicipioService extends BaseService<Municipio, MunicipioEmbeddedId, MunicipioDAO> {
    GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO getMunicipiosIdProvinciaIdProvinciaIdMunicipio(
            MunicipioEmbeddedId id, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException;
}
