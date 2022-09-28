package org.madrid.japi.rest.ejemplo.alumnos.municipio.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioEmbeddedId implements Serializable, Comparable<MunicipioEmbeddedId> {
    @Column(
            name = "CD_PROVINCIA"
    )
    @NotNull
    private String cdProvincia;

    @Column(
            name = "CD_MUNICIPIO"
    )
    @NotNull
    private String cdMunicipio;

    @Override
    public String toString() {
        return cdProvincia + "_" + cdMunicipio;
    }

    @Override
    public int compareTo(MunicipioEmbeddedId o) {
        int c;
        c = cdProvincia.compareTo(o.cdProvincia);
        if (c != 0) return c;
        c = cdMunicipio.compareTo(o.cdMunicipio);
        if (c != 0) return c;
        return c;
    }
}
