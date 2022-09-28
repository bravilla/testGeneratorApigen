package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.domain.SolicitudAdjunto;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("SolicitudAdjuntoDAO")
public class SolicitudAdjuntoDAOImpl extends JapiBaseDAOImpl<SolicitudAdjunto, Long> implements SolicitudAdjuntoDAO {
    public SolicitudAdjuntoDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
