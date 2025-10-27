package com.dreamteam.taller.service;

import com.dreamteam.taller.model.error.ErrorProceso;
import com.dreamteam.taller.repository.ErrorProcesoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ErrorProcesoService {

    private final ErrorProcesoRepository errorProcesoRepository;

    public ErrorProcesoService(ErrorProcesoRepository errorProcesoRepository) {
        this.errorProcesoRepository = errorProcesoRepository;
    }

    public List<ErrorProceso> obtenerErrores(){
        return errorProcesoRepository.findAll();
    }
}
