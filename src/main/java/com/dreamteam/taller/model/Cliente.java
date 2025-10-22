package com.dreamteam.taller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Cliente", schema = "ATB")
public class Cliente {

    @Id
    @Column(name = "NUMRUN", nullable = false)
    private Long numrun;

    @Column(name = "DVRUN", nullable = false, length = 1)
    private String dvrun;

    @Column(name = "PNOMBRE", nullable = false, length = 50)
    private String pnombre;

    @Column(name = "SNOMBRE", length = 50)
    private String snombre;

    @Column(name = "APPATERNO", nullable = false, length = 50)
    private String appaterno;

    @Column(name = "APMATERNO", length = 50)
    private String apmaterno;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "FECHA_INSCRIPCION", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "CORREO", length = 20)
    private String correo;

    @Column(name = "FONO_CONTACTO")
    private Long fonoContacto;

    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "COD_REGION", nullable = false)
    private Integer codRegion;

    @Column(name = "COD_PROVINCIA", nullable = false)
    private Integer codProvincia;

    @Column(name = "COD_COMUNA", nullable = false)
    private Integer codComuna;

    @Column(name = "COD_PROF_OFIC", nullable = false)
    private Integer codProfOfic;

    @Column(name = "COD_TIPO_CLIENTE", nullable = false)
    private Integer codTipoCliente;

}
