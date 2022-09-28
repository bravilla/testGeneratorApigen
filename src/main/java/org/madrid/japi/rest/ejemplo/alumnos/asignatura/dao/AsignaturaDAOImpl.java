package org.madrid.japi.rest.ejemplo.alumnos.asignatura.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("AsignaturaDAO")
public class AsignaturaDAOImpl extends JapiBaseDAOImpl<Asignatura, Long> implements AsignaturaDAO {
    public AsignaturaDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
