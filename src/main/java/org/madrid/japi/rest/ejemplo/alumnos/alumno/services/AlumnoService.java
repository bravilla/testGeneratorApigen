package org.madrid.japi.rest.ejemplo.alumnos.alumno.services;

import java.util.List;
import java.util.Set;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.exceptions.ServiceException;
import org.madrid.japi.javaapi.jpa.search.JapiPaginatedSearchResult;
import org.madrid.japi.javaapi.jpa.services.BaseService;
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
import org.springframework.web.util.ContentCachingRequestWrapper;

public interface AlumnoService extends BaseService<Alumno, Long, AlumnoDAO> {
    GetAlumnosUuidAlumnoOutputDTO getAlumnosUuidAlumno(String uuidAlumno, Set<String> select,
            Set<String> exclude, Set<String> expand) throws ServiceException, JapiException;

    PutAlumnosUuidAlumnoOutputDTO putAlumnosUuidAlumno(String id,
            PutAlumnosUuidAlumnoInputDTO inputDTO, ContentCachingRequestWrapper request) throws
            ServiceException, JapiException;

    void deleteAlumnosUuidAlumno(String id) throws ServiceException, JapiException;

    JapiPaginatedSearchResult<GetAlumnosOutputDTO> getAlumnos(Set<String> select,
            Set<String> exclude, Set<String> expand, List<String> orderby, Integer init,
            Integer limit, Boolean total) throws ServiceException, JapiException;

    PostAlumnosOutputDTO postAlumnos(PostAlumnosInputDTO inputDTO) throws ServiceException,
            JapiException;

    PostAlumnosGetOutputDTO postAlumnosGet(PostAlumnosGetInputDTO inputDTO) throws ServiceException,
            JapiException;

    GetAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicosOutputDTO getAlumnosUuidAlumnoDatosPublicosUuidAlumnoDatosPublicos(
            String uuidAlumno, Set<String> select, Set<String> exclude, Set<String> expand) throws
            ServiceException, JapiException;

    JapiPaginatedSearchResult<GetAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnosOutputDTO> getAsignaturasIdAsignaturaAlumnosIdAsignaturaAlumnos(
            Long idAsignatura, Set<String> select, Set<String> exclude, Set<String> expand,
            List<String> orderby, Integer init, Integer limit, Boolean total) throws
            ServiceException, JapiException;

    PostAlumnosResumenGetOutputDTO postAlumnosResumenGet(PostAlumnosResumenGetInputDTO inputDTO)
            throws ServiceException, JapiException;
}
