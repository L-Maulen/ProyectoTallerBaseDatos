package com.dreamteam.taller.service;

import com.dreamteam.taller.model.Cliente;
import com.dreamteam.taller.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    // Inyección de dependencias por constructor
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Guardar o actualizar cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por ID (numrun)
    public Optional<Cliente> buscarPorId(Long numrun) {
        return clienteRepository.findById(numrun);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long numrun) {
        clienteRepository.deleteById(numrun);
    }

    // Verificar si existe un cliente por ID
    public boolean existePorId(Long numrun) {
        return clienteRepository.existsById(numrun);
    }
}
