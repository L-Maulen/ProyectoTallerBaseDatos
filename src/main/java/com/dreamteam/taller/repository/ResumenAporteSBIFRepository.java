package com.dreamteam.taller.repository;

import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIF;
import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIFId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenAporteSBIFRepository extends JpaRepository<ResumenAporteSBIF, ResumenAporteSBIFId> {
    @Procedure(procedureName = "ATB.PKG_REPORTE_MENSUAL2.SP_CALCULO_APORTE")
    void ejecutarProcedimientoResumenAporteSBIF();
}
