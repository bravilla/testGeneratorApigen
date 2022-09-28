package org.madrid.japi.rest.ejemplo.alumnos.files.config;

import java.nio.file.Paths;

import org.madrid.core8.exceptions.StorageException;
import org.madrid.core8.model.local.impl.CompartidoStorageOptions;
import org.madrid.core8.services.local.CoreStorageServiceFactory;
import org.madrid.core8.services.local.fileid.CoreFileIDGenerator;
import org.madrid.core8.services.local.impl.CoreLocalStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.unit.DataSize;

/*
 * Configuración por defecto generada para el controlador de gestión de ficheros.
 *
 * Se configuran los servicios como Singleton, y se carga el tamaño del chunk y directorio compartido, de estar definidos
 * en los .properties
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Configuration("StorageServiceConfig")
public class StorageServiceConfig {

	@Value("${core8.storage.directorio-compartido:null}")
	private String directorioCompartido;

	@Value("${core8.storage.chunk-size:1MB}")
	private DataSize chunkSize;

	@Bean("storageTypeTemporal")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public CoreLocalStorageService initTemporalStorageService() throws StorageException {
		return CoreStorageServiceFactory.buildCoreTemporalStorageService(null);
	}

	@Bean("storageTypeCompartido")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public CoreLocalStorageService initCompartidoStorageService() throws StorageException {
		CompartidoStorageOptions storageOptions = new CompartidoStorageOptions();
		storageOptions.setChunkSizeInBytes((int) chunkSize.toBytes());
		storageOptions.setStoragePath(Paths.get(directorioCompartido));
		return CoreStorageServiceFactory.buildCoreCompartidoStorageService(storageOptions);
	}

	@Bean("coreFileIDGenerator")
	public CoreFileIDGenerator initCoreFileIDGenerator() throws StorageException {
		return new CoreFileIDGenerator();
	}
}
