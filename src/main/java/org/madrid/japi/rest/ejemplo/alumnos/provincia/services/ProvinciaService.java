package org.madrid.japi.rest.ejemplo.alumnos.provincia.services;

import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.dao.ProvinciaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.domain.Provincia;

public interface ProvinciaService extends BaseService<Provincia, String, ProvinciaDAO> {
}
