package com.dreamteam.taller.service;

import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIF;
import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIFId;
import com.dreamteam.taller.repository.ResumenAporteSBIFRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResumenAporteSBIFService {

    @Autowired
    private final ResumenAporteSBIFRepository resApSBIFRepository;

    public ResumenAporteSBIFService(ResumenAporteSBIFRepository ResApSBIFRepository){
        this.resApSBIFRepository = ResApSBIFRepository;
    }

    // Obtener todos los aportes
    public List<ResumenAporteSBIF> listarResumenAportes() {
        return resApSBIFRepository.findAll();
    }

    // Guardar o actualizar cliente
    public ResumenAporteSBIF guardarResumenAporte(ResumenAporteSBIF resumenAporteSBIF) {
        return resApSBIFRepository.save(resumenAporteSBIF);
    }

    // Buscar resumen por ID
    public Optional<ResumenAporteSBIF> listarResumenAporte(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        return resApSBIFRepository.findById(id);
    }

    // Eliminar resumen por ID
    public void eliminarResumenAporte(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        resApSBIFRepository.deleteById(id);
    }

    // Verificar si existe el resumen del aporte
    public boolean existePorId(String mes_anno, String tipo_transaccion) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        return resApSBIFRepository.existsById(id);
    }
}
