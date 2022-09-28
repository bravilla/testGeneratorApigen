package org.madrid.japi.rest.ejemplo.alumnos;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.madrid.japi.javaapi.core.config.MapperConfig;
import org.madrid.japi.javaapi.logger.filter.JapiLogFilterRequest;
import org.madrid.japi.javaapi.security.cors.CustomCrossOrigin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Clase Application<br/>
 *
 * @author Generador de API Rest 
 * @since 28-sep-2022 16:05:10
 */
@Slf4j
@SpringBootApplication
@Import(MapperConfig.class)
@EnableAutoConfiguration(
        exclude = HibernateJpaAutoConfiguration.class
)
@ComponentScan(
        basePackages = {"org.madrid.japi", "org.madrid.japi.rest.ejemplo.alumnos"}
)
@EnableConfigurationProperties(CustomCrossOrigin.class)
@ServletComponentScan(
        basePackageClasses = JapiLogFilterRequest.class
)
public class Application {
    /**
     * Zona horaria empleada en la aplicaciÃ³n, por defecto Europe/Madrid, configurable en el fichero .properties con la propiedad: default-time-zone
     */
    @Value("${default-time-zone:Europe/Madrid}")
    private String defaultTimeZone;

    /**
     * mÃ©todo principal de la aplicaciÃ³n
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        SpringApplication.run(Application.class, args);
    }

    /**
     * mÃ©todo para establecer la zona horaria una vez ha iniciado la aplicaciÃ³n
     */
    @PostConstruct
    void initTimeZone() {
        log.info("[INFO] - Established time zone to {}", defaultTimeZone);
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
    }
}
