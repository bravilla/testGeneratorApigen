package org.madrid.japi.rest.ejemplo.alumnos.nota.domain;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;
import org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain.Asignatura;

/**
 * Representa el objeto de dominio: <code>{@link Nota}</code><br/>
 * Mapea la tabla: JAPI_NOTA
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_NOTA"
)
@NoArgsConstructor
@AllArgsConstructor
public class Nota extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio Nota
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_NOTA",
            allocationSize = 1
    )
    @Column(
            name = "ID_NOTA"
    )
    @NotNull
    @NotNull
    private Long idNota;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_ALUMNO")
            })
    private Alumno idAlumno;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_ASIGNATURA")
            })
    private Asignatura idAsignatura;

    /**
     * Campo fcNota del objeto de dominio Nota
     */
    @Column(
            name = "FC_NOTA"
    )
    @NotNull
    private LocalDateTime fcNota;

    /**
     * Campo nmNota del objeto de dominio Nota
     */
    @Column(
            name = "NM_NOTA"
    )
    @NotNull
    private Long nmNota;

    public Nota(Long id) {
        this.setIdNota(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idNota;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idNota").append("=").append(getIdNota()).append("' ");
        builder.append("idAlumno").append("=").append(getIdAlumno()).append("' ");
        builder.append("idAsignatura").append("=").append(getIdAsignatura()).append("' ");
        builder.append("fcNota").append("=").append(getFcNota()).append("' ");
        builder.append("nmNota").append("=").append(getNmNota()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
