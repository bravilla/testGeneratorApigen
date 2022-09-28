package org.madrid.japi.rest.ejemplo.alumnos.files.dtos;

import java.time.ZonedDateTime;

import org.madrid.core8.model.local.StorageFileInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/*
 * DTO para las respuestas recibidas desde el controlador de gestión de ficheros, de no devolver este un fichero.
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Data
public class FileOutputDTO {

	@JsonProperty("file_id")
	private String fileID;

	@JsonProperty("path")
	private String filePath;

	@JsonProperty("storage_type")
	private String storageType;

	@JsonProperty("size_in_bytes")
	private Long fileSize;

	@JsonProperty("percent_complete")
	private Integer percentComplete;

	@JsonProperty("last_modified_date")
	private ZonedDateTime fileLastModifiedDate;

	public FileOutputDTO(StorageFileInfo storageInfo, String storageType, int chunk, int totalChunks) {
		this.fileID = storageInfo.getFileId();
		this.filePath = storageInfo.getFilePath().toUri().getPath();
		this.storageType = storageType;
		this.fileLastModifiedDate = storageInfo.getFileLastModifiedDate();

		if ((chunk == -1 && totalChunks == -1) || (chunk == totalChunks)) {
			this.fileSize = storageInfo.getFileSize();
		}

		if (chunk >= 1 && totalChunks >= 1 && totalChunks >= chunk) {
			this.percentComplete = (int) Math.floor((double) chunk / (totalChunks) * 100);
		}
	}

	/**
	 * Constructor para el caso específico de generación de ID de fichero
	 *
	 * @param 	fileID - Identificador de fichero generado, en caso de tener nombre el fichero, lo incluirá
	 */
	public FileOutputDTO(String fileID) {
		this.fileID = fileID;
	}
}
