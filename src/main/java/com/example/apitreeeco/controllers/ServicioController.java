package com.example.apitreeeco.controllers;

import com.example.apitreeeco.entities.Servicio;
import com.example.apitreeeco.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("servicios")
public class ServicioController implements ErrorController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String getServicios(Model modelo){
        modelo.addAttribute("categorias", servicioService.getCategorias());
        modelo.addAttribute("servicios", servicioService.getServicios());
        return "ver-servicios";
    }

     @GetMapping("/buscar")
    public String buscar(@RequestParam Optional<String> nombreORid, @RequestParam Optional<String>categoria, @RequestParam Optional<Integer>puntos){
        if(categoria.isPresent() && !categoria.get().equals("0"))
            return "redirect:/servicios/categoria/"+categoria.get();
        if(puntos.isPresent() && puntos.get()>0)
            return "redirect:/servicios/puntos/0/"+puntos.get();
        if(nombreORid.isPresent() && !nombreORid.get().isEmpty())
            try {
                Integer id = Integer.parseInt((nombreORid.get()));
                return "redirect:/servicios/id/"+id;
            }catch (NumberFormatException e){
                return "redirect:/servicios/nombre/"+nombreORid.get();
            }
        return "redirect:/servicios";
    }

    @GetMapping("/nombre/{nombre}")
    public String buscarPorNombre(ModelMap modelo, @PathVariable String nombre){
        modelo.addAttribute("categorias", servicioService.getCategorias());
        modelo.addAttribute("servicios", servicioService.findByNombreContaining(nombre));
        return "ver-servicios";
    }

    @GetMapping("/categoria/{categoria}")
    public String buscarPorCategoria(ModelMap modelo, @PathVariable String categoria){
        modelo.addAttribute("categorias", servicioService.getCategorias());
        modelo.addAttribute("servicios", servicioService.findByCategoriaContaining(categoria));
        return "ver-servicios";
    }

    @GetMapping("/id/{servicio_id}")
    public String buscarPorID(Model modelo, @PathVariable String servicio_id){
        modelo.addAttribute("categorias", servicioService.getCategorias());
        modelo.addAttribute("servicios", servicioService.getServicioByServicioId(servicio_id));
        return "ver-servicios";
    }

    @GetMapping("/nuevo")
    public String newServicio(Model modelo){
        modelo.addAttribute("servicio", new Servicio());
        return "guardar-servicio";
    }

    @GetMapping("/editar/{servicio_id}")
    public String editarServicio(Model modelo, @PathVariable String servicio_id){
        List<Servicio> servicio = servicioService.getServicioByServicioId(servicio_id);
        modelo.addAttribute("servicio",servicio.get(0));
        return "guardar-servicio";
    }

    @GetMapping("/puntos/{puntosDesde}/{puntosHasta}")
    public String findServiciosByPuntosBetween(Model modelo, @PathVariable Integer puntosDesde, @PathVariable Integer puntosHasta){
        modelo.addAttribute("categorias", servicioService.getCategorias());
        modelo.addAttribute("servicios", servicioService.findServiciosByPuntosBetween(puntosDesde, puntosHasta));
        return "ver-servicios";
    }

    @DeleteMapping("/borrar/{servicio_id")
    public String deleteServicio(@PathVariable Integer servicio_id){
        servicioService.deleteById(servicio_id);
        return "enviado";
    }

    @PostMapping("/guardar")
    public String saveServicio(@ModelAttribute Servicio servicio){
        servicioService.save(servicio);
        return "redirect:/servicios";
    }
}
