package com.dreamteam.taller.repository;

import com.dreamteam.taller.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
