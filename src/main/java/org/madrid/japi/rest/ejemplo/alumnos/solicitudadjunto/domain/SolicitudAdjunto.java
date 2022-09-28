package org.madrid.japi.rest.ejemplo.alumnos.solicitudadjunto.domain;

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
import org.madrid.japi.rest.ejemplo.alumnos.solicitud.domain.Solicitud;

/**
 * Representa el objeto de dominio: <code>{@link SolicitudAdjunto}</code><br/>
 * Mapea la tabla: JAPI_SOLICITUD_ADJUNTO
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_SOLICITUD_ADJUNTO"
)
@NoArgsConstructor
@AllArgsConstructor
@JapiAuditarFila
public class SolicitudAdjunto extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio SolicitudAdjunto
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_SOLICITUD_ADJUNTO",
            allocationSize = 1
    )
    @Column(
            name = "ID_ADJUNTO"
    )
    @NotNull
    private Long idAdjunto;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_SOLICITUD")
            })
    private Solicitud idSolicitud;

    /**
     * Campo idFica del objeto de dominio SolicitudAdjunto
     */
    @Column(
            name = "ID_FICA"
    )
    private String idFica;

    /**
     * Campo nombreFichero del objeto de dominio SolicitudAdjunto
     */
    @Column(
            name = "NOMBRE_FICHERO"
    )
    private String nombreFichero;

    /**
     * Campo tamanoBytes del objeto de dominio SolicitudAdjunto
     */
    @Column(
            name = "TAMANO_BYTES"
    )
    private Long tamanoBytes;

    /**
     * Campo cdUsuAlta del objeto de dominio SolicitudAdjunto
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
     * Campo fcAltaFila del objeto de dominio SolicitudAdjunto
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
     * Campo cdUsuModif del objeto de dominio SolicitudAdjunto
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
     * Campo fcModifFila del objeto de dominio SolicitudAdjunto
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHAMODIF
    )
    @Column(
            name = "FC_MODIF_FILA"
    )
    private LocalDateTime fcModifFila;

    /**
     * Campo cdUsuBaja del objeto de dominio SolicitudAdjunto
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
     * Campo fcBajaFila del objeto de dominio SolicitudAdjunto
     */
    @JapiAuditarCampo(
            tipo = JapiAuditarCampo.TiposAuditoria.FECHABAJA
    )
    @Column(
            name = "FC_BAJA_FILA"
    )
    private LocalDateTime fcBajaFila;

    public SolicitudAdjunto(Long id) {
        this.setIdAdjunto(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idAdjunto;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idAdjunto").append("=").append(getIdAdjunto()).append("' ");
        builder.append("idSolicitud").append("=").append(getIdSolicitud()).append("' ");
        builder.append("idFica").append("=").append(getIdFica()).append("' ");
        builder.append("nombreFichero").append("=").append(getNombreFichero()).append("' ");
        builder.append("tamanoBytes").append("=").append(getTamanoBytes()).append("' ");
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
