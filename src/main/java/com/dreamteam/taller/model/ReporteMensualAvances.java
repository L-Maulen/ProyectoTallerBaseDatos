package com.dreamteam.taller.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REPORTE_MENSUAL_AVANCES") // Nombre de la tabla en Oracle
public class ReporteMensualAvances {

    /**
     * Clave compuesta de la entidad.
     * La clave está definida y mapeada completamente en la clase ReporteMensualAvancesId.
     */
    @EmbeddedId
    private ReporteMensualAvancesId id;

    // Campos restantes (no hacen parte de la PK)

    @Column(name = "MONTO_TOTAL_TRANSACCIONES", nullable = true)
    private int montoTotalTransacciones;

    @Column(name = "APORTE_TOTAL_SBIF", nullable = true)
    private int aporteTotalAbif;

    // Métodos utilitarios para acceder a los campos de la clave fácilmente
    public Long getNumrun() {
        return id.getNumrun();
    }

    public String getFechaTransaccion() {
        return id.getFechaTransaccion();
    }

    public String getTipoTransaccion() {
        return id.getTipoTransaccion();
    }

}
