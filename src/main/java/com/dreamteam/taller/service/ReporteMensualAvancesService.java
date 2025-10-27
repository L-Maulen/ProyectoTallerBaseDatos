package com.dreamteam.taller.service;

import com.dreamteam.taller.model.ReporteMensualAvances;
import com.dreamteam.taller.repository.ReporteMensualAvancesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteMensualAvancesService {

    private final ReporteMensualAvancesRepository repository;

    public ReporteMensualAvancesService(ReporteMensualAvancesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void limpiarReporte(){
        repository.truncarTabla();
    }

    /**
     * Llama al procedimiento PL/SQL para generar el reporte
     * y retorna el número de filas insertadas (conteo post-ejecución).
     */

    @Transactional
    public int generarYContarReporte() {
        limpiarReporte();
        // Ejecutar el procedimiento PL/SQL que trunca e inserta los datos
        try {
            repository.ejecutarReportePLSQL();

            // Obtener el conteo final de filas
            List<ReporteMensualAvances> resultados = repository.findAll();
            return resultados.size();

            // Manejo de errores
        } catch (Exception e) {
            System.err.println("Error al ejecutar el procedimiento PL/SQL: " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al generar el reporte: " + e.getMessage());
        }
    }

    /**
     * Recupera todos los datos generados por el reporte.
     */
    public List<ReporteMensualAvances> obtenerReporte() {
        return repository.findAll();
    }
}
