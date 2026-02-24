package com.tevcol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_car")
    private Long codigoCar;

    @NotBlank(message = "El nombre del cargo es obligatorio")
    @Column(name = "nombre_car")
    private String nombreCar;

    // En tu captura aparece estado_car (ACTIVO/INACTIVO)
    @Column(name = "estado_car")
    private String estadoCar;

    // Campos que se ven en tu tabla (pueden quedar NULL)
    @Column(name = "area_car")
    private String areaCar;

    @Column(name = "proceso_car")
    private String procesoCar;

    @Column(name = "maquinaria_equipo_car")
    private String maquinariaEquipoCar;

    @Column(name = "nivel_riesgo_car")
    private String nivelRiesgoCar;

    @Column(name = "mision_car", columnDefinition = "TEXT")
    private String misionCar;

    // ========== GETTERS / SETTERS ==========
    public Long getCodigoCar() {
        return codigoCar;
    }

    public void setCodigoCar(Long codigoCar) {
        this.codigoCar = codigoCar;
    }

    public String getNombreCar() {
        return nombreCar;
    }

    public void setNombreCar(String nombreCar) {
        this.nombreCar = nombreCar;
    }

    public String getEstadoCar() {
        return estadoCar;
    }

    public void setEstadoCar(String estadoCar) {
        this.estadoCar = estadoCar;
    }

    public String getAreaCar() {
        return areaCar;
    }

    public void setAreaCar(String areaCar) {
        this.areaCar = areaCar;
    }

    public String getProcesoCar() {
        return procesoCar;
    }

    public void setProcesoCar(String procesoCar) {
        this.procesoCar = procesoCar;
    }

    public String getMaquinariaEquipoCar() {
        return maquinariaEquipoCar;
    }

    public void setMaquinariaEquipoCar(String maquinariaEquipoCar) {
        this.maquinariaEquipoCar = maquinariaEquipoCar;
    }

    public String getNivelRiesgoCar() {
        return nivelRiesgoCar;
    }

    public void setNivelRiesgoCar(String nivelRiesgoCar) {
        this.nivelRiesgoCar = nivelRiesgoCar;
    }

    public String getMisionCar() {
        return misionCar;
    }

    public void setMisionCar(String misionCar) {
        this.misionCar = misionCar;
    }
}