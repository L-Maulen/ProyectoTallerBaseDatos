package com.dreamteam.taller.model.ResumenAporteSBIF;

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

    private String mes_anno;
    private String tipo_transaccion;

    public void setMes_anno(String mes_anno) {
        this.mes_anno = mes_anno;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumenAporteSBIFId that = (ResumenAporteSBIFId) o;
        return Objects.equals(mes_anno, that.mes_anno) &&
                Objects.equals(tipo_transaccion, that.tipo_transaccion);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mes_anno, tipo_transaccion);
    }
}
