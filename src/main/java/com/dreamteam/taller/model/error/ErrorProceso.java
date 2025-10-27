package com.dreamteam.taller.model.error;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ERROR_PROCESO", schema = "ATB")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ErrorProceso {

    @Id
    @Column(name = "SEC_ERROR")
    private Long secError;

    @Column(name = "RUTINA_ERROR")
    private String rutinaError;

    @Column(name = "MENSAJE_ERROR")
    private String mensajeError;
}
