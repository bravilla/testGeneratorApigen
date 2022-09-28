package org.madrid.japi.rest.ejemplo.alumnos.files.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/*
 * DTO para las peticiones realizadas hacia el controlador de gestión de ficheros.
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Data
public class FileInputDTO {

	@JsonProperty("file_name")
	private String fileName;

	@JsonProperty("base64")
	private String base64;

	@JsonProperty(value = "storage_type")
	private String storageType = "COMPARTIDO";
}

