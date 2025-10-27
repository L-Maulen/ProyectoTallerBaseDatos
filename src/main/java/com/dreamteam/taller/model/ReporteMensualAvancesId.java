package com.dreamteam.taller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Clase que define la Clave Primaria COMPUESTA para ReporteMensualAvances.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable // Anotación clave: indica que esta clase se incrustará como clave
public class ReporteMensualAvancesId implements Serializable {

    // Primer componente de la clave
    @Column(name = "NUMRUN", nullable = false)
    private Long numrun;

    // Segundo componente de la clave
    @Column(name = "MES_ANNO_TRANSACCION", nullable = false)
    private String fechaTransaccion;

    // Tercer componente de la clave
    @Column(name = "TIPO_TRANSACCION", nullable = false)
    private String tipoTransaccion;


}
