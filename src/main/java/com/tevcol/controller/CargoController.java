package com.tevcol.controller;

import com.tevcol.model.Cargo;
import com.tevcol.service.CargoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cargos", cargoService.listar());
        return "cargos/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Cargo cargo = new Cargo();
        cargo.setEstadoCar("ACTIVO");
        model.addAttribute("cargo", cargo);
        return "cargos/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes ra) {
        Cargo cargo = cargoService.buscarPorId(id);
        if (cargo == null) {
            ra.addFlashAttribute("error", "Cargo no encontrado.");
            return "redirect:/cargos";
        }
        model.addAttribute("cargo", cargo);
        return "cargos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cargo cargo, RedirectAttributes ra) {
        try {
            cargoService.guardar(cargo);
            ra.addFlashAttribute("success", "Cargo guardado correctamente.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo guardar: " + e.getMessage());
        }
        return "redirect:/cargos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
        try {
            cargoService.eliminar(id);
            ra.addFlashAttribute("success", "Cargo eliminado correctamente.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo eliminar: " + e.getMessage());
        }
        return "redirect:/cargos";
    }
}