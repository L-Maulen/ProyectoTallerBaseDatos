package com.dreamteam.taller.controller;

import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIF;
import com.dreamteam.taller.model.ResumenAporteSBIF.ResumenAporteSBIFId;
import com.dreamteam.taller.service.ResumenAporteSBIFService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reporte2")
public class ResumenAporteSBIFController {

    // Inyección de dependencias
    private final ResumenAporteSBIFService resApSBIFService;

    public ResumenAporteSBIFController(ResumenAporteSBIFService resApSBIFService) {
        this.resApSBIFService = resApSBIFService;
    }

    @GetMapping
    public String listarResumenes(Model model) {
        List<ResumenAporteSBIF> resumenes = resApSBIFService.listarResumenAportes();
        model.addAttribute("resumenes", resumenes);
        model.addAttribute("resumenAporteSBIF", new ResumenAporteSBIF());
        return "reporte2";
    }

    @PostMapping("/")
    public String guardarResumenAporte(@ModelAttribute ResumenAporteSBIF nuevoResumenAporteSBIF){
        resApSBIFService.guardarResumenAporte(nuevoResumenAporteSBIF);
        return "redirect:/";
    }

    // Mostrar formulario para editar resumen
    @GetMapping("/editar/{mes_anno}/{tipo_transaccion}")
    public String mostrarEditar(@PathVariable String mes_anno, @PathVariable String tipo_transaccion, Model model) {
        ResumenAporteSBIF resumenAporteSBIF = resApSBIFService.listarResumenAporte(mes_anno, tipo_transaccion)
                        .orElseThrow(() -> new IllegalArgumentException("Resumen no encontrado: " + mes_anno + " " + tipo_transaccion));
        model.addAttribute("resumenAporteSBIF", resumenAporteSBIF);
        return "editarProcedimiento2";
    }

    // Recibir formulario edición
    @PostMapping("/editar/{mes_anno}/{tipo_transaccion}")
    public String editarResumenAporte(@PathVariable String mes_anno, @PathVariable String tipo_transaccion, @ModelAttribute("resumenAporteSBIF") ResumenAporteSBIF resumenAporteSBIF) {
        ResumenAporteSBIFId id = new ResumenAporteSBIFId(mes_anno, tipo_transaccion);
        resumenAporteSBIF.setId(id);
        resApSBIFService.guardarResumenAporte(resumenAporteSBIF);
        return "redirect:/";
    }

    // Borrar resumen
    @PostMapping("/borrar/{mes_anno}/{tipo_transaccion}")
    public String borrarResumenAporte(@PathVariable String mes_anno,
                                      @PathVariable String tipo_transaccion){
        resApSBIFService.eliminarResumenAporte(mes_anno, tipo_transaccion);
        return "redirect:/";
    }
}
