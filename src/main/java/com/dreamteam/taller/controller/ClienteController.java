package com.dreamteam.taller.controller;

import com.dreamteam.taller.model.Cliente;
import com.dreamteam.taller.repository.ClienteRepository;
import com.dreamteam.taller.service.ClienteService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Mostrar lista de clientes y formulario vacío para crear uno nuevo
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        return "index";
    }

    // Guardar nuevo cliente (recibe datos del formulario)
    @PostMapping("/")
    public String guardarCliente(@ModelAttribute Cliente usuarioNuevo) {
        clienteService.guardarCliente(usuarioNuevo);
        return "redirect:/";
    }

    // Mostrar formulario para editar cliente
    @GetMapping("/editar/{numrun}")
    public String mostrarEditar(@PathVariable Long numrun, Model model) {
        Cliente cliente = clienteService.buscarPorId(numrun)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado: " + numrun));
        model.addAttribute("clienteEditar", cliente);
        return "editar";  // plantilla editar.html
    }

    // Recibir formulario edición
    @PostMapping("/editar/{numrun}")
    public String editarCliente(@PathVariable Long numrun, @ModelAttribute("clienteEditar") Cliente clienteEditar) {
        clienteEditar.setNumrun(numrun);
        clienteService.guardarCliente(clienteEditar);
        return "redirect:/";
    }

    // Borrar cliente
    @PostMapping("/borrar/{numrun}")
    public String borrarCliente(@PathVariable Long numrun) {
        clienteService.eliminarCliente(numrun);
        return "redirect:/";
    }
}