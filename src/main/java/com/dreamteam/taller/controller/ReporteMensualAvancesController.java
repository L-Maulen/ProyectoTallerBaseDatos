package com.dreamteam.taller.controller;

import com.dreamteam.taller.model.ReporteMensualAvances;
import com.dreamteam.taller.service.ReporteMensualAvancesService;
import org.springframework.beans.factory.annotation.Autowired; // Importación necesaria
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Importación necesaria
import org.springframework.web.bind.annotation.RequestMapping; // Importación necesaria
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/reporte1")
public class ReporteMensualAvancesController {

    private final ReporteMensualAvancesService service;

    // Usar @Autowired para inyección de dependencia explícita
    @Autowired
    public ReporteMensualAvancesController(ReporteMensualAvancesService service) {
        this.service = service;
    }

    /**
     * Endpoint para cargar la página y mostrar los resultados actuales.
     * URL: GET /reporte
     */
    @GetMapping // Ya que la clase tiene /reporte, este mapea a /reporte
    public String verReporte(Model model) {
        // Asumimos que inicialmente puede haber datos (si viene de un redirect)
        List<ReporteMensualAvances> reportes = service.obtenerReporte();

        // Si NO hay mensajes flash, es una carga INICIAL o manual, por lo que limpiamos la tabla.
        if (!model.containsAttribute("mensaje") && !model.containsAttribute("error")) {
            // Ejecutamos la limpieza
            service.limpiarReporte();

            // Volvemos a leer la tabla, que ahora estará vacía
            reportes = service.obtenerReporte();

            // Ajustamos el mensaje por defecto
            model.addAttribute("mensaje", "Tabla limpiada. Haga clic en 'Generar y Recargar Reporte' para ejecutar el proceso de Oracle.");
        }

        model.addAttribute("reportes", reportes);
        model.addAttribute("filasTotales", reportes.size());

        return "reporte"; // dirige a src/main/resources/templates/reporte.html
    }

    /**
     * Endpoint para ejecutar el procedimiento almacenado y recargar la página.
     * URL: POST /reporte/generar
     */
    @PostMapping("/generar")
    public String generarReporte(RedirectAttributes redirectAttributes) {

        try {
            int filasInsertadas = service.generarYContarReporte();
            String mensaje = String.format("Reporte generado con éxito. Se insertaron %d filas.", filasInsertadas);
            // Flash Attribute para enviar el mensaje DESPUÉS de la redirección
            redirectAttributes.addFlashAttribute("mensaje", mensaje);

        } catch (RuntimeException e) {
            String error = "Error al ejecutar el proceso: " + e.getMessage();
            // Flash Attribute para enviar el error DESPUÉS de la redirección
            redirectAttributes.addFlashAttribute("error", error);
            e.printStackTrace();
        }

        // Redirige a la URL base (/reporte), que invoca el método @GetMapping
        return "redirect:/reporte1";
    }
}
