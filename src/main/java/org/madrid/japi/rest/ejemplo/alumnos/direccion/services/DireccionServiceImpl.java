package org.madrid.japi.rest.ejemplo.alumnos.direccion.services;

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
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dao.DireccionDAO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.GetDireccionesIdDireccionOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.dtos.PostDireccionesGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers.GetDireccionesIdDireccionOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers.PostDireccionesGetInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.mappers.PostDireccionesGetOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.validators.PostDireccionesGetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("DireccionServiceImpl")
public class DireccionServiceImpl extends JapiBaseServiceImpl<Direccion, Long, DireccionDAO> implements DireccionService {
    @Autowired
    private DireccionDAO direccionDAO;

    @Autowired
    private GetDireccionesIdDireccionOutputMapper getDireccionesIdDireccionOutputMapper;

    @Autowired
    private PostDireccionesGetValidator postDireccionesGetValidator;

    @Autowired
    private PostDireccionesGetInputMapper postDireccionesGetInputMapper;

    @Autowired
    private PostDireccionesGetOutputMapper postDireccionesGetOutputMapper;

    @Override
    public GetDireccionesIdDireccionOutputDTO getDireccionesIdDireccion(Long idDireccion,
            Set<String> select, Set<String> exclude, Set<String> expand) throws ServiceException,
            JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetDireccionesIdDireccionOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", idDireccion));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Direccion.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Direccion searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetDireccionesIdDireccionOutputDTO outputDTO = this.getDireccionesIdDireccionOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostDireccionesGetOutputDTO postDireccionesGet(PostDireccionesGetInputDTO inputDTO)
            throws ServiceException, JapiException {
        // TODO-JAPI: Este POST no devuelve una sola entidad, con lo cual el servicio se deja por hacer para que sea implementado como se necesite

        // TODO-JAPI: El DTO no corresponde a una entidad, por lo que el mapper asociado se crea pero no mapea ningÃºn campo
        PostDireccionesGetOutputDTO outputDTO = new PostDireccionesGetOutputDTO();

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
