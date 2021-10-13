package com.example.apitreeeco.controllers;

import com.example.apitreeeco.entities.Consulta;
import com.example.apitreeeco.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ConsultaController implements ErrorController{

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/")
    public String inicio(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    //@GetMapping("/productos")
    //public String productos(){
     //   return "productos";
    //}

    /*@GetMapping("/servicios")
    public String servicios(){
        return "servicios";
    }*/

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/enviado")
    public String enviado()
    {
        return "enviado";
    }

    @GetMapping("consultas")
    public String mostrasUnaSola(Model modelo){
        List<Consulta>consultas = consultaService.getConsultas();

        modelo.addAttribute("id",consultas.get(0).getConsulta_id());
        modelo.addAttribute("nombre", consultas.get(0).getNombre());
        modelo.addAttribute("apellido", consultas.get(0).getApellido());
        modelo.addAttribute("email", consultas.get(0).getEmail());
        modelo.addAttribute("telefono", consultas.get(0).getTelefono());
        modelo.addAttribute("texto", consultas.get(0).getTexto());
        return "ver-consultas";

    }

    @GetMapping("/consultastodas")
    public String getConsultas(Model modelo) {
        modelo.addAttribute("nombres", consultaService.getNombres());
        modelo.addAttribute("apellidos", consultaService.getApellidos());
        modelo.addAttribute("emails", consultaService.getEmails());
        modelo.addAttribute("telefonos", consultaService.getTelefonos());
        modelo.addAttribute("textos", consultaService.getTextos());
        return "ver-consultas";
    }

    @GetMapping("consultas/buscar")
    public String buscar(@RequestParam Optional<String> nombreORid, @RequestParam Optional<String>apellido, @RequestParam Optional<String>email, @RequestParam Optional<String>telefono){
        if(apellido.isPresent() && !apellido.get().equals("0"))
            return "redirect:/consultas/apellido/"+apellido.get();

        if(email.isPresent() && !email.get().equals("0"))
            return "redirect:/consultas/email/"+email.get();
        if(telefono.isPresent() && !telefono.get().equals("0"))
            return "redirect:/consultas/telefono/"+telefono.get();
        if(nombreORid.isPresent() && !nombreORid.get().isEmpty())
            try {
                Integer id = Integer.parseInt(nombreORid.get());
                return "redirect:/consultas/id/"+id;
            }catch (NumberFormatException e){
                return "redirect:/consultas/nombre/"+nombreORid.get();
            }
        return "redirect:/consultas";
    }

    @GetMapping("/nombre/{nombre}")
    public String buscarPorNombre(Model modelo, @PathVariable String nombre){
        modelo.addAttribute("apellidos",consultaService.getApellidos());
        modelo.addAttribute("emails", consultaService.getEmails());
        modelo.addAttribute("telefonos", consultaService.getTelefonos());
        modelo.addAttribute("textos", consultaService.getTextos());
        modelo.addAttribute("consultas",consultaService.findByNombreContaining(nombre));
        return "ver-consultas";
    }

    @GetMapping("/apellido/{apellido}")
    public String buscarPorApellido(Model modelo, @PathVariable String apellido){
        modelo.addAttribute("nombres", consultaService.getNombres());
        modelo.addAttribute("emails",consultaService.getEmails());
        modelo.addAttribute("telefonos", consultaService.getTelefonos());
        modelo.addAttribute("textos",consultaService.getTextos());
        modelo.addAttribute("consultas", consultaService.findByApellidoContaining(apellido));
        return "ver-consultas";
    }

    @GetMapping("/email/{email}")
    public String buscarPorEmail(Model modelo, @PathVariable String email){
        modelo.addAttribute("nombres",consultaService.getNombres());
        modelo.addAttribute("apellidos", consultaService.getApellidos());
        modelo.addAttribute("telefonos", consultaService.getTelefonos());
        modelo.addAttribute("textos", consultaService.getTextos());
        modelo.addAttribute("consultas", consultaService.findByEmailContaining(email));
        return "ver-consultas";
    }

    @GetMapping("/telefono/{telefono}")
    public String buscarPorTelefono(Model modelo, @PathVariable String telefono){
        modelo.addAttribute("nombres",consultaService.getNombres());
        modelo.addAttribute("apellidos",consultaService.getApellidos());
        modelo.addAttribute("emails", consultaService.getEmails());
        modelo.addAttribute("textos", consultaService.getTextos());
        modelo.addAttribute("consultas", consultaService.findByTelefonoContaining(telefono));
        return "ver-consultas";
    }

    @GetMapping("/id/{consulta_id}")
    public String buscarPorID(Model modelo, @PathVariable String consulta_id){
        modelo.addAttribute("nombres", consultaService.getNombres());
        modelo.addAttribute("apellidos", consultaService.getApellidos());
        modelo.addAttribute("emails", consultaService.getEmails());
        modelo.addAttribute("telefonos",consultaService.getTelefonos());
        modelo.addAttribute("textos", consultaService.getTextos());
        modelo.addAttribute("consultas", consultaService.getConsultaByConsulta_id(consulta_id));
        return "ver-consultas";
    }

    @GetMapping("/contacto")
    public String newConsulta(Model modelo){
        modelo.addAttribute("consulta", new Consulta());
        return "contacto";
    }

    @GetMapping("/editar/{consulta_id}")
    public String editarConsulta(Model modelo, @PathVariable String consulta_id){
        List<Consulta> consulta = consultaService.getConsultaByConsulta_id(consulta_id);
        modelo.addAttribute("consulta", consulta.get(0));
        return "contacto";
    }

    @DeleteMapping("/borrar/{consulta_id}")
    public String deleteConsulta(@PathVariable Integer consulta_id){
        consultaService.deleteById(consulta_id);
        return "ver-consultas";
    }

    @PostMapping("/guardar")
    public String saveConsulta(@ModelAttribute Consulta consulta){
        consultaService.save(consulta);
        return "redirect:/consultas";
    }

}
