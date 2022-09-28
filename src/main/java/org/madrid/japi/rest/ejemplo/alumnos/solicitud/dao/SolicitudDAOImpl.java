package org.madrid.japi.rest.ejemplo.alumnos.solicitud.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("SolicitudDAO")
public class SolicitudDAOImpl extends JapiBaseDAOImpl<Solicitud, Long> implements SolicitudDAO {
    public SolicitudDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
