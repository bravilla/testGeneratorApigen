package org.madrid.japi.rest.ejemplo.alumnos.solicitud.services;

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
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dao.SolicitudDAO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.GetSolicitudesBecasIdSolicitudBecaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.dtos.PostSolicitudesBecasOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.mappers.GetSolicitudesBecasIdSolicitudBecaOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.mappers.PostSolicitudesBecasInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.mappers.PostSolicitudesBecasOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.validators.PostSolicitudesBecasValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("SolicitudServiceImpl")
public class SolicitudServiceImpl extends JapiBaseServiceImpl<Solicitud, Long, SolicitudDAO> implements SolicitudService {
    @Autowired
    private SolicitudDAO solicitudDAO;

    @Autowired
    private PostSolicitudesBecasValidator postSolicitudesBecasValidator;

    @Autowired
    private PostSolicitudesBecasInputMapper postSolicitudesBecasInputMapper;

    @Autowired
    private PostSolicitudesBecasOutputMapper postSolicitudesBecasOutputMapper;

    @Autowired
    private GetSolicitudesBecasIdSolicitudBecaOutputMapper getSolicitudesBecasIdSolicitudBecaOutputMapper;

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostSolicitudesBecasOutputDTO postSolicitudesBecas(PostSolicitudesBecasInputDTO inputDTO)
            throws ServiceException, JapiException {
        // Se validan los parÃ¡metros de entrada
        this.postSolicitudesBecasValidator.doValidate(inputDTO);

        // Convertimos el inputDTO a la entidad destino
        Solicitud entity = this.postSolicitudesBecasInputMapper.dtoToEntity(inputDTO);

        // Calculamos las variables derivadas que se van a insertar en base de datos

        // Validaciones de negocio antes de insertar

        // Llamamos al insert del BaseService y mapeamos el resultado a OutputDTO
        Solicitud insertedEntity = this.insert(entity);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        PostSolicitudesBecasOutputDTO outputDTO = this.postSolicitudesBecasOutputMapper.entityToDto(entity);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Override
    public GetSolicitudesBecasIdSolicitudBecaOutputDTO getSolicitudesBecasIdSolicitudBeca(
            Long idSolicitudBeca, Set<String> select, Set<String> exclude, Set<String> expand)
            throws ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetSolicitudesBecasIdSolicitudBecaOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", idSolicitudBeca));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Solicitud.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Solicitud searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetSolicitudesBecasIdSolicitudBecaOutputDTO outputDTO = this.getSolicitudesBecasIdSolicitudBecaOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
