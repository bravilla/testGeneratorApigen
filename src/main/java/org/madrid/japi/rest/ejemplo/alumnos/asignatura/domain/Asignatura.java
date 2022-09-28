package org.madrid.japi.rest.ejemplo.alumnos.asignatura.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.madrid.japi.javaapi.model.JapiAbstractEntity;
import org.madrid.japi.rest.ejemplo.alumnos.alumno.domain.Alumno;

/**
 * Representa el objeto de dominio: <code>{@link Asignatura}</code><br/>
 * Mapea la tabla: JAPI_ASIGNATURA
 */
@Getter
@Setter
@Entity
@Table(
        name = "JAPI_ASIGNATURA"
)
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura extends JapiAbstractEntity<Long> implements Serializable {
    /**
     * Identificador del objeto de dominio Asignatura
     */
    @Id
    @GeneratedValue(
            generator = "generator",
            strategy = GenerationType.AUTO
    )
    @SequenceGenerator(
            name = "generator",
            sequenceName = "JAPI_S_ASIGNATURA",
            allocationSize = 1
    )
    @Column(
            name = "ID_ASIGNATURA"
    )
    @NotNull
    private Long idAsignatura;

    @ManyToMany(
            mappedBy = "asignaturas"
    )
    private Set<Alumno> alumnoes;

    /**
     * Campo dsAsignatura del objeto de dominio Asignatura
     */
    @Column(
            name = "DS_ASIGNATURA"
    )
    private String dsAsignatura;

    /**
     * Campo nmCurso del objeto de dominio Asignatura
     */
    @Column(
            name = "NM_CURSO"
    )
    private String nmCurso;

    /**
     * Campo idProfesor del objeto de dominio Asignatura
     */
    @Column(
            name = "ID_PROFESOR"
    )
    private Long idProfesor;

    /**
     * Campo dsProfesor del objeto de dominio Asignatura
     */
    @Column(
            name = "DS_PROFESOR"
    )
    @Size
    private String dsProfesor;

    public Asignatura(Long id) {
        this.setIdAsignatura(id);
    }

    /**
     * ImplementaciÃ³n de JAPI para obtener el identificador de la entidad
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return idAsignatura;
    }

    /**
     * ImplementaciÃ³n de toString() para este objeto de modelo
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        builder.append("idAsignatura").append("=").append(getIdAsignatura()).append("' ");
        builder.append("alumnoes").append("=").append(getAlumnoes()).append("' ");
        builder.append("dsAsignatura").append("=").append(getDsAsignatura()).append("' ");
        builder.append("nmCurso").append("=").append(getNmCurso()).append("' ");
        builder.append("idProfesor").append("=").append(getIdProfesor()).append("' ");
        builder.append("dsProfesor").append("=").append(getDsProfesor()).append("' ");
        builder.append("]");
        return builder.toString();
    }
}
