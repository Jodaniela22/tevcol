package com.tevcol.service;

import com.tevcol.model.Cargo;
import com.tevcol.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository repo;

    public CargoService(CargoRepository repo) {
        this.repo = repo;
    }

    public List<Cargo> listar() {
        return repo.findAll();
    }

    public Cargo buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void guardar(Cargo cargo) {
        repo.save(cargo);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}