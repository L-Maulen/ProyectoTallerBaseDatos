package com.dreamteam.taller.repository;

import com.dreamteam.taller.model.ReporteMensualAvances;
import com.dreamteam.taller.model.ReporteMensualAvancesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReporteMensualAvancesRepository extends JpaRepository<ReporteMensualAvances, ReporteMensualAvancesId> {
    @Modifying
    @Query(value = "TRUNCATE TABLE REPORTE_MENSUAL_AVANCES", nativeQuery = true)
    void truncarTabla();

    /**
     * Consulta nativa de Oracle para llamar al procedimiento almacenado
     * que está dentro del package.
     * @return 1 si el procedimiento se llamó con éxito (retorno simbólico).
     */
    @Modifying
    @Query(value = "{CALL PKG_REPORTE_MENSUAL.SP_REPORTE_CLIENTES()}", nativeQuery = true)
    void ejecutarReportePLSQL();

    List<ReporteMensualAvances> findAll();
}
