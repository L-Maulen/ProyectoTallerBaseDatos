package com.dreamteam.taller.controller;

import com.dreamteam.taller.service.ErrorProcesoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorProcesoController {

    private final ErrorProcesoService errorProcesoService;

    public ErrorProcesoController(ErrorProcesoService errorProcesoService) {
        this.errorProcesoService = errorProcesoService;
    }

    @GetMapping("/errorProcesos")
    public String mostrarErrores(Model model){
        model.addAttribute("errores", errorProcesoService.obtenerErrores());
        return "errorProcesos";
    }
}
