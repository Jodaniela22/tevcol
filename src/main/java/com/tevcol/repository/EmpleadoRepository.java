package com.tevcol.repository;

import com.tevcol.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    boolean existsByIdentificacionEmp(String identificacionEmp);
}