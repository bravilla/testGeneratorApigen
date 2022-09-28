package org.madrid.japi.rest.ejemplo.alumnos.alumno.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.madrid.japi.javaapi.jpa.auditable.JapiAuditarCampo;
import org.madrid.japi.javaapi.jpa.auditable.JapiAuditarFila;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;
import org.madrid.japi.rest.ejemplo.alumnos.direccion.domain.Direccion;

/**
 * Representa el objeto de dominio: <code>{@link Alumno}</code><br/>
 * Mapea la tabla: JAPI_ALUMNO
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_ALUMNO"
)
@NoArgsConstructor
@AllArgsConstructor
@JapiAuditarFila
public class Alumno extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio Alumno
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_ALUMNO",
            allocationSize = 1
    )
    @Column(
            name = "ID_ALUMNO"
    )
    @NotNull
    private Long idAlumno;

    @ManyToMany(
            mappedBy = "alumnoes"
    )
    private Set<Asignatura> asignaturas;

    /**
     * Campo uuid del objeto de dominio Alumno
     */
    @Column(
            name = "UUID"
    )
    private String uuid;

    /**
     * Campo nif del objeto de dominio Alumno
     */
    @Column(
            name = "NIF"
    )
    private String nif;

    /**
     * Campo dsNombre del objeto de dominio Alumno
     */
    @Column(
            name = "DS_NOMBRE"
    )
    private String dsNombre;

    /**
     * Campo dsApellido1 del objeto de dominio Alumno
     */
    @Column(
            name = "DS_APELLIDO1"
    )
    private String dsApellido1;

    /**
     * Campo dsApellido2 del objeto de dominio Alumno
     */
    @Column(
            name = "DS_APELLIDO2"
    )
    private String dsApellido2;

    /**
     * Campo fcNacimiento del objeto de dominio Alumno
     */
    @Column(
            name = "FC_NACIMIENTO"
    )
    private LocalDateTime fcNacimiento;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_DIRECCION1")
            })
    private Direccion idDireccion1;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_DIRECCION2")
            })
    private Direccion idDireccion2;

    /**
     * Campo telefono del objeto de dominio Alumno
     */
    @Column(
            name = "TELEFONO"
    )
    @Size
    private String telefono;

    /**
     * Campo cdUsuAlta del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.USUALTA
    )
    @Column(
            name = "CD_USU_ALTA"
    )
    @NotNull
    @Size
    private String cdUsuAlta;

    /**
     * Campo fcAltaFila del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHAALTA
    )
    @Column(
            name = "FC_ALTA_FILA"
    )
    @NotNull
    private LocalDateTime fcAltaFila;

    /**
     * Campo cdUsuModif del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.USUMODIF
    )
    @Column(
            name = "CD_USU_MODIF"
    )
    @Size
    private String cdUsuModif;

    /**
     * Campo fcModifFila del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHAMODIF
    )
    @Column(
            name = "FC_MODIF_FILA"
    )
    private LocalDateTime fcModifFila;

    /**
     * Campo cdUsuBaja del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.USUBAJA
    )
    @Column(
            name = "CD_USU_BAJA"
    )
    @Size
    private String cdUsuBaja;

    /**
     * Campo fcBajaFila del objeto de dominio Alumno
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHABAJA
    )
    @Column(
            name = "FC_BAJA_FILA"
    )
    private LocalDateTime fcBajaFila;

    public Alumno(Long id) {
        this.setIdAlumno(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idAlumno;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idAlumno").append("=").append(getIdAlumno()).append("' ");
        builder.append("asignaturas").append("=").append(getAsignaturas()).append("' ");
        builder.append("uuid").append("=").append(getUuid()).append("' ");
        builder.append("nif").append("=").append(getNif()).append("' ");
        builder.append("dsNombre").append("=").append(getDsNombre()).append("' ");
        builder.append("dsApellido1").append("=").append(getDsApellido1()).append("' ");
        builder.append("dsApellido2").append("=").append(getDsApellido2()).append("' ");
        builder.append("fcNacimiento").append("=").append(getFcNacimiento()).append("' ");
        builder.append("idDireccion1").append("=").append(getIdDireccion1()).append("' ");
        builder.append("idDireccion2").append("=").append(getIdDireccion2()).append("' ");
        builder.append("telefono").append("=").append(getTelefono()).append("' ");
        builder.append("cdUsuAlta").append("=").append(getCdUsuAlta()).append("' ");
        builder.append("fcAltaFila").append("=").append(getFcAltaFila()).append("' ");
        builder.append("cdUsuModif").append("=").append(getCdUsuModif()).append("' ");
        builder.append("fcModifFila").append("=").append(getFcModifFila()).append("' ");
        builder.append("cdUsuBaja").append("=").append(getCdUsuBaja()).append("' ");
        builder.append("fcBajaFila").append("=").append(getFcBajaFila()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
