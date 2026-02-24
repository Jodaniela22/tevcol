package com.tevcol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_emp")
    private Long codigoEmp;

    @NotBlank(message = "La identificación es obligatoria")
    @Pattern(regexp = "^[0-9]{10,13}$", message = "Debe tener 10 a 13 dígitos")
    @Column(name = "identificacion_emp")
    private String identificacionEmp;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Column(name = "nombre_emp")
    private String nombreEmp;

    @NotBlank(message = "El segundo nombre es obligatorio (si no aplica pon '-')")
    @Column(name = "segundo_nombre_emp")
    private String segundoNombreEmp;

    @NotBlank(message = "El primer apellido es obligatorio")
    @Column(name = "apellido_emp")
    private String apellidoEmp;

    @NotBlank(message = "El segundo apellido es obligatorio (si no aplica pon '-')")
    @Column(name = "segundo_apellido_emp")
    private String segundoApellidoEmp;

    @NotNull(message = "Seleccione el sexo")
    @Min(value = 1, message = "Sexo inválido")
    @Max(value = 2, message = "Sexo inválido")
    @Column(name = "sexo_emp")
    private Integer sexoEmp; // 1 Hombre, 2 Mujer

    @Column(name = "estado_emp")
    private String estadoEmp; // Activo/Inactivo

    // Getters & Setters
    public Long getCodigoEmp() { return codigoEmp; }
    public void setCodigoEmp(Long codigoEmp) { this.codigoEmp = codigoEmp; }

    public String getIdentificacionEmp() { return identificacionEmp; }
    public void setIdentificacionEmp(String identificacionEmp) { this.identificacionEmp = identificacionEmp; }

    public String getNombreEmp() { return nombreEmp; }
    public void setNombreEmp(String nombreEmp) { this.nombreEmp = nombreEmp; }

    public String getSegundoNombreEmp() { return segundoNombreEmp; }
    public void setSegundoNombreEmp(String segundoNombreEmp) { this.segundoNombreEmp = segundoNombreEmp; }

    public String getApellidoEmp() { return apellidoEmp; }
    public void setApellidoEmp(String apellidoEmp) { this.apellidoEmp = apellidoEmp; }

    public String getSegundoApellidoEmp() { return segundoApellidoEmp; }
    public void setSegundoApellidoEmp(String segundoApellidoEmp) { this.segundoApellidoEmp = segundoApellidoEmp; }

    public Integer getSexoEmp() { return sexoEmp; }
    public void setSexoEmp(Integer sexoEmp) { this.sexoEmp = sexoEmp; }

    public String getEstadoEmp() { return estadoEmp; }
    public void setEstadoEmp(String estadoEmp) { this.estadoEmp = estadoEmp; }
}