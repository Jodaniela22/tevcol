package com.tevcol.service;

import com.tevcol.model.Empleado;
import com.tevcol.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public List<Empleado> listar() {
        return repo.findAll();
    }

    public Empleado buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void guardar(Empleado e) {
        repo.save(e); // si trae codigoEmp -> actualiza, si null -> inserta
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}