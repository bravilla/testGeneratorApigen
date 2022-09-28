package org.madrid.japi.rest.ejemplo.alumnos.municipio.dao;

import org.madrid.japi.javaapi.jpa.dao.BaseDAO;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.MunicipioEmbeddedId;

public interface MunicipioDAO extends BaseDAO<Municipio, MunicipioEmbeddedId> {
}
