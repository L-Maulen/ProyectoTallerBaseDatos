package com.dreamteam.taller.service;

import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIF;
import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIFId;
import com.dreamteam.taller.repository.ResumenAporteSBIFRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResumenAporteSBIFService {

    private final ResumenAporteSBIFRepository resApSBIFRepository;

    @Autowired
    public ResumenAporteSBIFService(ResumenAporteSBIFRepository ResApSBIFRepository){
        this.resApSBIFRepository = ResApSBIFRepository;
    }

    // Ejecutar procedimiento almacenado
    public void ejecutarProcedimientoResumenAporteSBIF() {
        resApSBIFRepository.ejecutarProcedimientoResumenAporteSBIF();
    }

    // Obtener todos los aportes
    public List<ResumenAporteSBIF> listarResumenAportes() {
        return resApSBIFRepository.findAll();
    }

    // Guardar/actualizar
    public ResumenAporteSBIF guardarResumenAporte(ResumenAporteSBIF resumenAporteSBIF) {
        return resApSBIFRepository.save(resumenAporteSBIF);
    }

    // Buscar por ID
    public Optional<ResumenAporteSBIF> listarResumenAporte(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        return resApSBIFRepository.findById(id);
    }

    // Borrar
    public void eliminarResumenAporte(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        resApSBIFRepository.deleteById(id);
    }

    // Existe
    public boolean existePorId(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        return resApSBIFRepository.existsById(id);
    }
}
