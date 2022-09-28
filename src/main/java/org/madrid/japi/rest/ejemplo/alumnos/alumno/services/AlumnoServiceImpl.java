package org.madrid.japi.rest.ejemplo.alumnos.alumno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.madrid.core.search.jpa.data.impl.CoreJpaFilter;
import org.madrid.core.search.jpa.data.impl.CoreJpaSearch;
import org.madrid.core.search.jpa.data.impl.CoreJpaSearchResult;
import org.madrid.japi.javaapi.dto.scan.JsonToEntityUtils;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.search.JapiPaginatedSearchResult;
import org.madrid.japi.javaapi.jpa.services.JapiBaseServiceImpl;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dao.AlumnoDAO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAlumnosUuidAlumnoOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PostAlumnosResumenGetOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PutAlumnosUuidAlumnoInputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.dtos.PutAlumnosUuidAlumnoOutputDTO;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.GetAlumnosOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.GetAlumnosUuidAlumnoOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosGetInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosGetOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosResumenGetInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PostAlumnosResumenGetOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PutAlumnosUuidAlumnoInputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.mappers.PutAlumnosUuidAlumnoOutputMapper;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosGetValidator;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosResumenGetValidator;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PostAlumnosValidator;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.validators.PutAlumnosUuidAlumnoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Slf4j
@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl extends JapiBaseServiceImpl<Alumno, Long, AlumnoDAO> implements AlumnoService {
    @Autowired
    private AlumnoDAO alumnoDAO;

    @Autowired
    private GetAlumnosUuidAlumnoOutputMapper getAlumnosUuidAlumnoOutputMapper;

    @Autowired
    private PutAlumnosUuidAlumnoValidator putAlumnosUuidAlumnoValidator;

    @Autowired
    private PutAlumnosUuidAlumnoInputMapper putAlumnosUuidAlumnoInputMapper;

    @Autowired
    private PutAlumnosUuidAlumnoOutputMapper putAlumnosUuidAlumnoOutputMapper;

    @Autowired
    private GetAlumnosOutputMapper getAlumnosOutputMapper;

    @Autowired
    private PostAlumnosValidator postAlumnosValidator;

    @Autowired
    private PostAlumnosInputMapper postAlumnosInputMapper;

    @Autowired
    private PostAlumnosOutputMapper postAlumnosOutputMapper;

    @Autowired
    private PostAlumnosGetValidator postAlumnosGetValidator;

    @Autowired
    private PostAlumnosGetInputMapper postAlumnosGetInputMapper;

    @Autowired
    private PostAlumnosGetOutputMapper postAlumnosGetOutputMapper;

    @Autowired
    private GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputMapper getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputMapper;

    @Autowired
    private GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputMapper getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputMapper;

    @Autowired
    private PostAlumnosResumenGetValidator postAlumnosResumenGetValidator;

    @Autowired
    private PostAlumnosResumenGetInputMapper postAlumnosResumenGetInputMapper;

    @Autowired
    private PostAlumnosResumenGetOutputMapper postAlumnosResumenGetOutputMapper;

    @Override
    public GetAlumnosUuidAlumnoOutputDTO getAlumnosUuidAlumno(String uuidAlumno, Set<String> select,
            Set<String> exclude, Set<String> expand) throws ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetAlumnosUuidAlumnoOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", uuidAlumno));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Alumno.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Alumno searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetAlumnosUuidAlumnoOutputDTO outputDTO = this.getAlumnosUuidAlumnoOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PutAlumnosUuidAlumnoOutputDTO putAlumnosUuidAlumno(String id,
            PutAlumnosUuidAlumnoInputDTO inputDTO, ContentCachingRequestWrapper request) throws
            ServiceException, JapiException {
        // Valida los parÃ¡metros de entrada
        this.putAlumnosUuidAlumnoValidator.doValidate(inputDTO);

        // Validaciones de negocio
        // Llama al servicio para hacer la consulta a base de datos
        Alumno entity = super.find(Long.valueOf(id));

        // Realiza la actualizaciÃ³n, mapeando el DTO de entrada definido por el usuario a una entidad, llamando al servicio para actualizar los datos y mapeando el resultado de vuelta
        entity = this.putAlumnosUuidAlumnoInputMapper.dtoToEntity(inputDTO);
        Alumno updatedEntity = super.update(entity);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        PutAlumnosUuidAlumnoOutputDTO outputDTO = this.putAlumnosUuidAlumnoOutputMapper.entityToDto(updatedEntity);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Override
    public void deleteAlumnosUuidAlumno(String id) throws ServiceException, JapiException {
        // Llama al servicio para hacer la consulta a base de datos
        Alumno entity = super.find(Long.valueOf(id));

        super.delete(entity);
    }

    @Override
    public JapiPaginatedSearchResult<GetAlumnosOutputDTO> getAlumnos(Set<String> select,
            Set<String> exclude, Set<String> expand, List<String> orderby, Integer init,
            Integer limit, Boolean total) throws ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetAlumnosOutputDTO.AlumnosOutputDTO.class, select, exclude, expand);
        List<String> orderEntityNames = JsonToEntityUtils.traslateOrderBy(GetAlumnosOutputDTO.class, orderby);

        // Preparamos la llamada al servicio para hacer la consulta a BBDD
        CoreJpaSearch search = new CoreJpaSearch(Alumno.class)
                .applyFieldsToSearch(selectEntityNames)
                .applyPagination(init, limit)
                .applySort(orderEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        CoreJpaSearchResult<Alumno> searchResult = super.findAll(search, total);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        List<Alumno> searchResultEntities = searchResult.getEntities();
        GetAlumnosOutputDTO outputDTO = this.getAlumnosOutputMapper.entityToDto(searchResultEntities);

        // Calculamos las variables derivadas del JSON de salida

        return new JapiPaginatedSearchResult<>(outputDTO, searchResult.getTotal());
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostAlumnosOutputDTO postAlumnos(PostAlumnosInputDTO inputDTO) throws ServiceException,
            JapiException {
        // Se validan los parÃ¡metros de entrada
        this.postAlumnosValidator.doValidate(inputDTO);

        // Convertimos el inputDTO a la entidad destino
        Alumno entity = this.postAlumnosInputMapper.dtoToEntity(inputDTO);

        // Calculamos las variables derivadas que se van a insertar en base de datos

        // Validaciones de negocio antes de insertar

        // Llamamos al insert del BaseService y mapeamos el resultado a OutputDTO
        Alumno insertedEntity = this.insert(entity);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        PostAlumnosOutputDTO outputDTO = this.postAlumnosOutputMapper.entityToDto(entity);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostAlumnosGetOutputDTO postAlumnosGet(PostAlumnosGetInputDTO inputDTO) throws
            ServiceException, JapiException {
        // TODO-JAPI: Este POST no devuelve una sola entidad, con lo cual el servicio se deja por hacer para que sea implementado como se necesite

        // TODO-JAPI: El DTO no corresponde a una entidad, por lo que el mapper asociado se crea pero no mapea ningÃºn campo
        PostAlumnosGetOutputDTO outputDTO = new PostAlumnosGetOutputDTO();

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Override
    public GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicos(
            String uuidAlumno, Set<String> select, Set<String> exclude, Set<String> expand) throws
            ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO.class, select, exclude, expand);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", uuidAlumno));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD

        // TODO-JAPI: ATENCIÃ“N. Se devuelve un elemento, pero no se estÃ¡ filtrando en la bÃºsqueda. Definir y aÃ±adir estos filtros con 'addFilters'
        CoreJpaSearch search = new CoreJpaSearch(Alumno.class)
                .applyFieldsToSearch(selectEntityNames);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        Alumno searchResult = super.findUnique(search);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO outputDTO = this.getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputMapper.entityToDto(searchResult);

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }

    @Override
    public JapiPaginatedSearchResult<GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO> getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnos(
            Long idAsignatura, Set<String> select, Set<String> exclude, Set<String> expand,
            List<String> orderby, Integer init, Integer limit, Boolean total) throws
            ServiceException, JapiException {
        // Convierte las variables pasadas como querystring o en el body a variables que hacen referencia a la base de datos
        List<String> selectEntityNames = JsonToEntityUtils.traslateFields(GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO.AlumnosOutputDTO.class, select, exclude, expand);
        List<String> orderEntityNames = JsonToEntityUtils.traslateOrderBy(GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO.class, orderby);
        // TODO-JAPI: el campo por el que se intenta filtrar no se ha mapeado por lo que se ha dejado como "id" 
        // Se define un filtro propio
        List<CoreJpaFilter> filters = new ArrayList<>();
        filters.add(CoreJpaFilter.equal("id", idAsignatura));

        // Preparamos la llamada al servicio para hacer la consulta a BBDD
        CoreJpaSearch search = new CoreJpaSearch(Alumno.class)
                .applyFieldsToSearch(selectEntityNames)
                .applyPagination(init, limit)
                .applySort(orderEntityNames)
                .addFilters(filters);

        // Hacemos la consulta a BBDD servicio para hacer la consulta a BBDD
        CoreJpaSearchResult<Alumno> searchResult = super.findAll(search, total);

        // Transforma el resultado de base de datos al especificado por el usuario (y definido en los objetos OutputDTO)
        List<Alumno> searchResultEntities = searchResult.getEntities();
        GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO outputDTO = this.getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputMapper.entityToDto(searchResultEntities);

        // Calculamos las variables derivadas del JSON de salida

        return new JapiPaginatedSearchResult<>(outputDTO, searchResult.getTotal());
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = { ServiceException.class, RuntimeException.class }
    )
    @Override
    public PostAlumnosResumenGetOutputDTO postAlumnosResumenGet(
            PostAlumnosResumenGetInputDTO inputDTO) throws ServiceException, JapiException {
        // TODO-JAPI: Este POST no devuelve una sola entidad, con lo cual el servicio se deja por hacer para que sea implementado como se necesite

        // TODO-JAPI: El DTO no corresponde a una entidad, por lo que el mapper asociado se crea pero no mapea ningÃºn campo
        PostAlumnosResumenGetOutputDTO outputDTO = new PostAlumnosResumenGetOutputDTO();

        // Calculamos las variables derivadas del JSON de salida

        return outputDTO;
    }
}
