package org.madrid.japi.rest.ejemplo.alumnos.provincia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;

/**
 * Representa el objeto de dominio: <code>{@link Provincia}</code><br/>
 * Mapea la tabla: JAPI_PROVINCIA
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_PROVINCIA"
)
@NoArgsConstructor
@AllArgsConstructor
public class Provincia extends JapiAbstractEntity<String> implements Serializable {
    /**
     * Identificador del objeto de dominio Provincia
     */
    @Id
    @GeneratedValue(
            generator = "uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid2"
    )
    @Column(
            name = "CD_PROVINCIA"
    )
    @NotNull
    @NotNull
    private String cdProvincia;

    /**
     * Campo dsProvincia del objeto de dominio Provincia
     */
    @Column(
            name = "DS_PROVINCIA"
    )
    @NotNull
    private String dsProvincia;

    @OneToMany(
            mappedBy = ""
    )
    @JsonBackReference
    private Set<Direccion> direcciones;

    public Provincia(String id) {
        this.setCdProvincia(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public String getEntityId() {
        return cdProvincia;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("cdProvincia").append("=").append(getCdProvincia()).append("' ");
        builder.append("dsProvincia").append("=").append(getDsProvincia()).append("' ");
        builder.append("direcciones").append("=").append(getDirecciones()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
