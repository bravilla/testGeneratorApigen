package org.madrid.japi.rest.ejemplo.alumnos.municipio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.core.search.jpa.data.impl.CoreJpaFilter;
import org.madrid.core.search.jpa.data.impl.CoreJpaSearch;
import org.madrid.japi.javaapi.dto.scan.JsonToEntityUtils;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.services.JapiBaseServiceImpl;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dao.MunicipioDAO;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.MunicipioEmbeddedId;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.dtos.GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.mappers.GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("MunicipioServiceImpl")
public class MunicipioServiceImpl extends JapiBaseServiceImpl<Municipio, MunicipioEmbeddedId, MunicipioDAO> implements MunicipioService {
    @Autowired
    private MunicipioDAO municipioDAO;

    @Autowired
    private GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputMapper getMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputMapper;

    @Override
    public GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO getMunicipiosIdProvinciaIdProvinciaIdMunicipio(
            MunicipioEmbeddedId id, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO.class, select, exclude, expand);
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", id));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCI?????N. Se devuelve un elemento, pero no se est???? filtrando en la b????squeda. Definir y a????adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Municipio.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Municipio searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputDTO outputDTO = this.getMunicipiosIdProvinciaIdProvinciaIdMunicipioOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
