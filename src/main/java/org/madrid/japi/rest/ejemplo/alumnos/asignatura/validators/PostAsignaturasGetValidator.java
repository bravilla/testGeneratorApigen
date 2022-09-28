package org.madrid.japi.rest.ejemplo.alumnos.asignatura.validators;

import org.madrid.japi.javaapi.exceptions.JapiErrorList;
import org.madrid.japi.javaapi.exceptions.JapiException;
import org.madrid.japi.javaapi.model.validator.JapiAbstractCustomValidator;
import org.madrid.japi.javaapi.model.validator.JapiCustomValidator;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.dtos.PostAsignaturasGetInputDTO;
import org.springframework.stereotype.Service;

/**
 * Servicio de validaciÃ³n de la clase de dominio Asignatura: <code>{@link PostAsignaturasGetValidator}</code><br/>
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Service("PostAsignaturasGetValidator")
public class PostAsignaturasGetValidator extends JapiAbstractCustomValidator<PostAsignaturasGetInputDTO> implements JapiCustomValidator<PostAsignaturasGetInputDTO> {
    /**
     * mÃ©todo de validaciÃ³n del DTO de entrada, de haber algÃºn fallo se devuelve un listado con los errores.
     */
    @Override
    public void doValidate(PostAsignaturasGetInputDTO inputDTO) throws JapiException {
        JapiErrorList errors = new JapiErrorList();
        if (!errors.getErrors().isEmpty()) {
            throw new JapiException(errors);
        }
    }
}
