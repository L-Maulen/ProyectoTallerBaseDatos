package com.dreamteam.taller.model.ResumenAporteSBIF;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resumen_aporte_sbif", schema = "ATB")
public class ResumenAporteSBIF {

    @EmbeddedId
    private ResumenAporteSBIFId id;

    @Column(name = "MONTO_TOTAL_TRANSACCIONES", nullable = false)
    private int montoTotalTransacciones;

    @Column(name = "APORTE_TOTAL_ABIF", nullable = false)
    private int aporteTotalAbif;
}
