package org.madrid.japi.rest.ejemplo.alumnos.provincia.services;

import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.jpa.services.JapiBaseServiceImpl;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.dao.ProvinciaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.domain.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("ProvinciaServiceImpl")
public class ProvinciaServiceImpl extends JapiBaseServiceImpl<Provincia, String, ProvinciaDAO> implements ProvinciaService {
    @Autowired
    private ProvinciaDAO provinciaDAO;
}
