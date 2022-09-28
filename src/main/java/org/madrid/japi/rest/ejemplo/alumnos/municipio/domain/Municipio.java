package org.madrid.japi.rest.ejemplo.alumnos.municipio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;

/**
 * Representa el objeto de dominio: <code>{@link Municipio}</code><br/>
 * Mapea la tabla: JAPI_MUNICIPIO
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_MUNICIPIO"
)
@NoArgsConstructor
@AllArgsConstructor
public class Municipio extends JapiAbstractEntity<MunicipioEmbeddedId> implements Serializable {
    /**
     * Clave primaria compuesta de la entidad  Municipio
     */
    @EmbeddedId
    private MunicipioEmbeddedId id;

    /**
     * Campo dsMunicipio del objeto de dominio Municipio
     */
    @Column(
            name = "DS_MUNICIPIO"
    )
    private String dsMunicipio;

    public Municipio(MunicipioEmbeddedId id) {
        this.setId(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public MunicipioEmbeddedId getEntityId() {
        return id;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("id").append("=").append(getId()).append("' ");
        builder.append("dsMunicipio").append("=").append(getDsMunicipio()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
