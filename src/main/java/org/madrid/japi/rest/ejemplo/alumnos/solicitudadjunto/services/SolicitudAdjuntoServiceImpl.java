package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.services;

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
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dao.SolicitudAdjuntoDAO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.domain.SolicitudAdjunto;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.dtos.GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.mappers.GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.mappers.PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SolicitudAdjuntoServiceImpl")
public class SolicitudAdjuntoServiceImpl extends JapiBaseServiceImpl<SolicitudAdjunto, Long, SolicitudAdjuntoDAO> implements SolicitudAdjuntoService {
    @Autowired
    private SolicitudAdjuntoDAO solicitudAdjuntoDAO;

    @Autowired
    private PostSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputMapper postSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoOutputMapper;

    @Autowired
    private GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputMapper getSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputMapper;

    @Override
    public GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO getSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjunto(
            Long idSolicitudBeca, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", idSolicitudBeca));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(SolicitudAdjunto.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        SolicitudAdjunto searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputDTO outputDTO = this.getSolicitudesBecasIdSolicitudBecaAdjuntoIdSolicitudBecaAdjuntoIdAdjuntoOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
