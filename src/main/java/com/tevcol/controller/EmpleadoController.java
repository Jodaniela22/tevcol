package com.tevcol.controller;

import com.tevcol.model.Empleado;
import com.tevcol.service.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model,
                         @ModelAttribute("success") String success,
                         @ModelAttribute("error") String error) {

        model.addAttribute("empleados", empleadoService.listar());
        return "empleados/listar";
    }

    // NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/form";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        Empleado empleado = empleadoService.buscarPorId(id);
        if (empleado == null) {
            ra.addFlashAttribute("error", "Empleado no encontrado.");
            return "redirect:/empleados";
        }
        model.addAttribute("empleado", empleado);
        return "empleados/form";
    }

    // GUARDAR (sirve para crear y editar)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado, RedirectAttributes ra, Model model) {
        try {
            empleadoService.guardar(empleado);
            ra.addFlashAttribute("success", "Empleado guardado correctamente.");
            return "redirect:/empleados";
        } catch (Exception ex) {
            // Vuelve al form si algo falla
            model.addAttribute("empleado", empleado);
            model.addAttribute("error", "No se pudo guardar. " + ex.getMessage());
            return "empleados/form";
        }
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            empleadoService.eliminar(id);
            ra.addFlashAttribute("success", "Empleado eliminado correctamente.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo eliminar: " + e.getMessage());
        }
        return "redirect:/empleados";
    }
}