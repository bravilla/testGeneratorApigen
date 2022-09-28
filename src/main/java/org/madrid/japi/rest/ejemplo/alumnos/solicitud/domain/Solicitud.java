package org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
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
import org.madrid.japi.javaapi.jpa.auditable.JapiAuditarCampo;
import org.madrid.japi.javaapi.jpa.auditable.JapiAuditarFila;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;

/**
 * Representa el objeto de dominio: <code>{@link Solicitud}</code><br/>
 * Mapea la tabla: JAPI_SOLICITUD
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_SOLICITUD"
)
@NoArgsConstructor
@AllArgsConstructor
@JapiAuditarFila
public class Solicitud extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio Solicitud
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_SOLICITUD",
            allocationSize = 1
    )
    @Column(
            name = "ID_SOLICITUD"
    )
    @NotNull
    private Long idSolicitud;

    /**
     * Campo fcSolicitud del objeto de dominio Solicitud
     */
    @Column(
            name = "FC_SOLICITUD"
    )
    private LocalDateTime fcSolicitud;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_ALUMNO")
            })
    private Alumno idAlumno;

    /**
     * Campo nifPresentante del objeto de dominio Solicitud
     */
    @Column(
            name = "NIF_PRESENTANTE"
    )
    private String nifPresentante;

    /**
     * Campo tipoSolicitud del objeto de dominio Solicitud
     */
    @Column(
            name = "TIPO_SOLICITUD"
    )
    private String tipoSolicitud;

    /**
     * Campo observaciones del objeto de dominio Solicitud
     */
    @Column(
            name = "OBSERVACIONES"
    )
    private String observaciones;

    /**
     * Campo cdUsuAlta del objeto de dominio Solicitud
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
     * Campo fcAltaFila del objeto de dominio Solicitud
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
     * Campo cdUsuModif del objeto de dominio Solicitud
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
     * Campo fcModifFila del objeto de dominio Solicitud
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHAMODIF
    )
    @Column(
            name = "FC_MODIF_FILA"
    )
    private LocalDateTime fcModifFila;

    /**
     * Campo cdUsuBaja del objeto de dominio Solicitud
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
     * Campo fcBajaFila del objeto de dominio Solicitud
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHABAJA
    )
    @Column(
            name = "FC_BAJA_FILA"
    )
    private LocalDateTime fcBajaFila;

    public Solicitud(Long id) {
        this.setIdSolicitud(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idSolicitud;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idSolicitud").append("=").append(getIdSolicitud()).append("' ");
        builder.append("fcSolicitud").append("=").append(getFcSolicitud()).append("' ");
        builder.append("idAlumno").append("=").append(getIdAlumno()).append("' ");
        builder.append("nifPresentante").append("=").append(getNifPresentante()).append("' ");
        builder.append("tipoSolicitud").append("=").append(getTipoSolicitud()).append("' ");
        builder.append("observaciones").append("=").append(getObservaciones()).append("' ");
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
