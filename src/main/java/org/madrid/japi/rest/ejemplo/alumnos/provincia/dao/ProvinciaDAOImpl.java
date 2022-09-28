package org.madrid.japi.rest.ejemplo.alumnos.provincia.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.domain.Provincia;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("ProvinciaDAO")
public class ProvinciaDAOImpl extends JapiBaseDAOImpl<Provincia, String> implements ProvinciaDAO {
    public ProvinciaDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
