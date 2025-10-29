package com.dreamteam.taller.model.ResumenAporteSBIF;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResumenAporteSBIFId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "MES_ANNO", nullable = false)
    private String mesAnno;

    @Column(name = "TIPO_TRANSACCION", nullable = false)
    private String tipoTransaccion;

    public void setMes_anno(String mesAnno) {
        this.mesAnno = mesAnno;
    }

    public void setTipo_transaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumenAporteSBIFId that = (ResumenAporteSBIFId) o;
        return Objects.equals(mesAnno, that.mesAnno) &&
                Objects.equals(tipoTransaccion, that.tipoTransaccion);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mesAnno, tipoTransaccion);
    }
}
