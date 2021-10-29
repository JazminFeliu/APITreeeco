package com.example.apitreeeco.controllers;

import com.example.apitreeeco.entities.Usuario;
import com.example.apitreeeco.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }
    @PostMapping("/auth/registro")
    public String registro(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model){

        if(result.hasErrors()){
            return "redirect:/auth/registro";
        }
        else {
            model.addAttribute("usuario", usuarioService.registrar(usuario));
        }
        return "redirect:/auth/login";
    }
}
