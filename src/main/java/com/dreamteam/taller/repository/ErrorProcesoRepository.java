package com.dreamteam.taller.repository;

import com.dreamteam.taller.model.error.ErrorProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorProcesoRepository extends JpaRepository<ErrorProceso, Long> {
}
