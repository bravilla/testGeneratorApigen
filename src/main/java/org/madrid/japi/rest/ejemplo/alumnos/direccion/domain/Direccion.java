package org.madrid.japi.rest.ejemplo.alumnos.direccion.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.municipio.domain.Municipio;
import org.madrid.japi.rest.ejemplo.alumnos.provincia.domain.Provincia;

/**
 * Representa el objeto de dominio: <code>{@link Direccion}</code><br/>
 * Mapea la tabla: JAPI_DIRECCION
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_DIRECCION"
)
@NoArgsConstructor
@AllArgsConstructor
public class Direccion extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio Direccion
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_DIRECCION",
            allocationSize = 1
    )
    @Column(
            name = "ID_DIRECCION"
    )
    @NotNull
    private Long idDireccion;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CD_PROVINCIA")
            })
    private Provincia cdProvincia;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CD_MUNICIPIO", insertable = false, updatable = false), @JoinColumn(name = "CD_PROVINCIA", insertable = false, updatable = false)
            })
    private Municipio cdMunicipio;

    /**
     * Campo cdVial del objeto de dominio Direccion
     */
    @Column(
            name = "CD_VIAL"
    )
    private String cdVial;

    /**
     * Campo dsVial del objeto de dominio Direccion
     */
    @Column(
            name = "DS_VIAL"
    )
    @NotNull
    @Size
    private String dsVial;

    /**
     * Campo nmNumero del objeto de dominio Direccion
     */
    @Column(
            name = "NM_NUMERO"
    )
    private Long nmNumero;

    /**
     * Campo dsCalificador del objeto de dominio Direccion
     */
    @Column(
            name = "DS_CALIFICADOR"
    )
    @Size
    private String dsCalificador;

    /**
     * Campo dsPlanta del objeto de dominio Direccion
     */
    @Column(
            name = "DS_PLANTA"
    )
    @Size
    private String dsPlanta;

    /**
     * Campo dsPuerta del objeto de dominio Direccion
     */
    @Column(
            name = "DS_PUERTA"
    )
    @Size
    private String dsPuerta;

    public Direccion(Long id) {
        this.setIdDireccion(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idDireccion;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idDireccion").append("=").append(getIdDireccion()).append("' ");
        builder.append("cdProvincia").append("=").append(getCdProvincia()).append("' ");
        builder.append("cdMunicipio").append("=").append(getCdMunicipio()).append("' ");
        builder.append("cdVial").append("=").append(getCdVial()).append("' ");
        builder.append("dsVial").append("=").append(getDsVial()).append("' ");
        builder.append("nmNumero").append("=").append(getNmNumero()).append("' ");
        builder.append("dsCalificador").append("=").append(getDsCalificador()).append("' ");
        builder.append("dsPlanta").append("=").append(getDsPlanta()).append("' ");
        builder.append("dsPuerta").append("=").append(getDsPuerta()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
