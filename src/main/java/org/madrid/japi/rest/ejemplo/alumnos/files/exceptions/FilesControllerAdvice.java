package org.madrid.japi.rest.ejemplo.alumnos.files.exceptions;

import org.madrid.core8.exceptions.StorageException;
import org.madrid.japi.javaapi.exceptions.JapiError;
import org.madrid.japi.javaapi.exceptions.JapiErrorImpl;
import org.madrid.japi.javaapi.exceptions.management.JapiExceptionManager;
import org.madrid.japi.javaapi.responses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * ControllerAdvice asociado al controlador de gestión de ficheros.
 * Las excepciones propagadas desde este controlador se pueden capturar y tratar mediante la anotación @ExceptionHandler
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@ControllerAdvice
public class FilesControllerAdvice {

	@Autowired
    private JapiExceptionManager exceptionManager;

	@ExceptionHandler(StorageException.class)
	public ResponseEntity<StandardResponse<?>> handleStorageException(StorageException e) {
		JapiError japiError = new JapiErrorImpl(e.getError().getHttpCode(), e.getError().getInfo(), e.getError().getErrorCode(), e.getError().getErrorMessage());
		return exceptionManager.manageException(e, japiError);
	}

}