package org.madrid.japi.rest.ejemplo.alumnos.direccion.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("DireccionDAO")
public class DireccionDAOImpl extends JapiBaseDAOImpl<Direccion, Long> implements DireccionDAO {
    public DireccionDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
