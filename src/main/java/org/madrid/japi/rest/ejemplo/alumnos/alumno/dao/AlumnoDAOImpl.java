package org.madrid.japi.rest.ejemplo.alumnos.alumno.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("AlumnoDAO")
public class AlumnoDAOImpl extends JapiBaseDAOImpl<Alumno, Long> implements AlumnoDAO {
    public AlumnoDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
