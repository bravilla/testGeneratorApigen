package org.madrid.japi.rest.ejemplo.alumnos.nota.services;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.jpa.services.JapiBaseServiceImpl;
import org.madrid.japi.rest.ejemplo.alumnos.nota.dao.NotaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.nota.domain.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("NotaServiceImpl")
public class NotaServiceImpl extends JapiBaseServiceImpl<Nota, Long, NotaDAO> implements NotaService {
    @Autowired
    private NotaDAO notaDAO;
}
