package com.example.apitreeeco.controllers;

import com.example.apitreeeco.entities.Producto;
import com.example.apitreeeco.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("productos")
public class ProductoController implements ErrorController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getProductos(Model modelo){
        modelo.addAttribute("categorias", productoService.getCategorias());
        modelo.addAttribute("productos", productoService.getProductos());
        return "ver-productos";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam Optional<String> nombreORid, @RequestParam Optional<String>categoria, @RequestParam Optional<Integer>puntos){
        if(categoria.isPresent() && !categoria.get().equals("0"))
            return "redirect:/productos/categoria/"+categoria.get();
        if(puntos.isPresent() && puntos.get()>0)
            return "redirect:/productos/puntos/0/"+puntos.get();
        if(nombreORid.isPresent() && !nombreORid.get().isEmpty())
            try {
                Integer id = Integer.parseInt(nombreORid.get());
                return "redirect:/productos/id/"+id;
            }catch (NumberFormatException e){
                return "redirect:/productos/nombre/"+nombreORid.get();
            }
        return "redirect:/productos";
    }

    @GetMapping("/nombre/{nombre}")
    public String buscarPorNombre(ModelMap modelo, @PathVariable String nombre){
        modelo.addAttribute("categorias", productoService.getCategorias());
        modelo.addAttribute("productos", productoService.findByNombreContaining(nombre));
        return "ver-productos";
    }

    @GetMapping("/categoria/{categoria}")
    public String buscarPorCategoria(ModelMap modelo, @PathVariable String categoria){
        modelo.addAttribute("categorias", productoService.getCategorias());
        modelo.addAttribute("productos", productoService.findByCategoriaContaining(categoria));
        return "ver-productos";
    }

    @GetMapping("/id/{productoId}")
    public String buscarPorID(Model modelo, @PathVariable String productoId){
        modelo.addAttribute("categorias", productoService.getCategorias());
        modelo.addAttribute("productos", productoService.getProductoByProductoId(productoId));
        return "ver-productos";
    }

    @GetMapping("/nuevo")
    public String newProducto(Model modelo){
        modelo.addAttribute("producto", new Producto());
        return "guardar-producto";
    }

    @GetMapping("/editar/{productoId}")
    public String editarProducto(Model modelo, @PathVariable String productoId){
        List<Producto> producto = productoService.getProductoByProductoId(productoId);
        modelo.addAttribute("producto", producto.get(0));
        return "guardar-producto";
    }

    @GetMapping("/puntos/{puntosDesde}/{puntosHasta}")
    public String findProductosByPuntosBetween(Model modelo, @PathVariable Integer puntosDesde, @PathVariable Integer puntosHasta){
        modelo.addAttribute("categorias", productoService.getCategorias());
        modelo.addAttribute("productos", productoService.findProductosByPuntosBetween(puntosDesde, puntosHasta));
        return "ver-productos";
    }

    @DeleteMapping("/borrar/{productoId}")
    public String deleteProducto(@PathVariable Integer productoId){
        productoService.deleteById(productoId);
        return "enviado";
    }


    @PostMapping("/guardar")
    public String saveProducto(@ModelAttribute Producto producto){
        productoService.save(producto);
        return "redirect:/productos";
    }
}
