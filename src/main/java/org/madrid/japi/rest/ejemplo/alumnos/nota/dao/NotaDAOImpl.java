package org.madrid.japi.rest.ejemplo.alumnos.nota.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.nota.domain.Nota;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("NotaDAO")
public class NotaDAOImpl extends JapiBaseDAOImpl<Nota, Long> implements NotaDAO {
    public NotaDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
