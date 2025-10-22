package com.dreamteam.taller.controller;

import com.dreamteam.taller.model.Cliente;
import com.dreamteam.taller.repository.ClienteRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Mostrar lista de clientes y formulario vacío para crear uno nuevo
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        return "index";
    }

    // Guardar nuevo cliente (recibe datos del formulario)
    @PostMapping("/")
    public String guardarCliente(@ModelAttribute Cliente usuarioNuevo) {
        clienteRepository.save(usuarioNuevo);
        return "redirect:/";
    }

    // Mostrar formulario para editar cliente
    @GetMapping("/editar/{numrun}")
    public String mostrarEditar(@PathVariable Long numrun, Model model) {
        Cliente cliente = clienteRepository.findById(numrun)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado: " + numrun));
        model.addAttribute("clienteEditar", cliente);
        return "editar";  // plantilla editar.html
    }

    // Recibir formulario edición
    @PostMapping("/editar/{numrun}")
    public String editarCliente(@PathVariable Long numrun, @ModelAttribute("clienteEditar") Cliente clienteEditar) {
        clienteEditar.setNumrun(numrun); // asegura que no se cambie el ID
        clienteRepository.save(clienteEditar);
        return "redirect:/";
    }

    // Borrar cliente
    @PostMapping("/borrar/{numrun}")
    public String borrarCliente(@PathVariable Long numrun) {
        clienteRepository.deleteById(numrun);
        return "redirect:/";
    }
}