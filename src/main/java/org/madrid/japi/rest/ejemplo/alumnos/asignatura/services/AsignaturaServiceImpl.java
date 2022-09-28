package org.madrid.japi.rest.ejemplo.alumnos.asignatura.services;

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
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dao.AsignaturaDAO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.GetAsignaturasIdAsignaturaOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers.GetAsignaturasIdAsignaturaOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers.PostAsignaturasGetInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.mappers.PostAsignaturasGetOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.validators.PostAsignaturasGetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("AsignaturaServiceImpl")
public class AsignaturaServiceImpl extends JapiBaseServiceImpl<Asignatura, Long, AsignaturaDAO> implements AsignaturaService {
    @Autowired
    private AsignaturaDAO asignaturaDAO;

    @Autowired
    private GetAsignaturasIdAsignaturaOutputMapper getAsignaturasIdAsignaturaOutputMapper;

    @Autowired
    private PostAsignaturasGetValidator postAsignaturasGetValidator;

    @Autowired
    private PostAsignaturasGetInputMapper postAsignaturasGetInputMapper;

    @Autowired
    private PostAsignaturasGetOutputMapper postAsignaturasGetOutputMapper;

    @Override
    public GetAsignaturasIdAsignaturaOutputDTO getAsignaturasIdAsignatura(Long idAsignatura,
            Set<String> select, Set<String> exclude, Set<String> expand) throws ServiceException,
            JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetAsignaturasIdAsignaturaOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", idAsignatura));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Asignatura.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Asignatura searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetAsignaturasIdAsignaturaOutputDTO outputDTO = this.getAsignaturasIdAsignaturaOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostAsignaturasGetOutputDTO postAsignaturasGet(PostAsignaturasGetInputDTO inputDTO)
            throws ServiceException, JapiException {
        // TODO-JAPI: Este POST no devuelve una sola entidad, con lo cual el servicio se deja por hacer para que sea implementado como se necesite

        // TODO-JAPI: El DTO no corresponde a una entidad, por lo que el mapper asociado se crea pero no mapea ningÃºn campo
        PostAsignaturasGetOutputDTO outputDTO = new PostAsignaturasGetOutputDTO();

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
