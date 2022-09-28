package org.madrid.japi.rest.ejemplo.alumnos.nota.services;

import org.madrid.japi.javaapi.jpa.services.BaseService;
import org.madrid.japi.rest.ejemplo.alumnos.nota.dao.NotaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.nota.domain.Nota;

public interface NotaService extends BaseService<Nota, Long, NotaDAO> {
}
