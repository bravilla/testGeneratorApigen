package org.madrid.japi.rest.ejemplo.alumnos.municipio.dao;

import org.madrid.japi.javaapi.jpa.dao.JapiBaseDAOImpl;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.MunicipioEmbeddedId;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("MunicipioDAO")
public class MunicipioDAOImpl extends JapiBaseDAOImpl<Municipio, MunicipioEmbeddedId> implements MunicipioDAO {
    public MunicipioDAOImpl(HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }
}
