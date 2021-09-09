package com.example.apitreeeco.services;

import com.example.apitreeeco.entities.Consulta;
import com.example.apitreeeco.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public List<Consulta> getConsultaByConsulta_id(String consulta_id){
        Integer id;
        try{
            id = Integer.parseInt(consulta_id);
        }catch (NumberFormatException e){
            id = 0;
        }
        return consultaRepository.findAllById(List.of(id));
    }

    public void deleteById(Integer id){
        consultaRepository.deleteById(id);
    }

    public List<Consulta> findByNombreContaining(String nombre){
        return consultaRepository.findDistinctByNombreContaining(nombre);
    }

    public List<Consulta> findByApellidoContaining(String apellido){
        return consultaRepository.findDistinctByApellidoContaining(apellido);
    }

    public List<Consulta> findByEmailContaining(String email) {
        return consultaRepository.findDistinctByEmailContaining(email);
    }

    public List<Consulta>findByTelefonoContaining(String telefono){
        return consultaRepository.findDistinctByTelefonoContaining(telefono);
    }

    public List<String> getNombres() {
        return consultaRepository.findDistinctByNombre();
    }

    public List<String>getApellidos(){
        return consultaRepository.findDistinctByApellido();
    }

    public List<String>getEmails(){
        return consultaRepository.findDistinctByEmail();
    }

    public List<String>getTelefonos(){
        return consultaRepository.findDistinctByTelefono();
    }

    public List<String>getTextos(){
        return consultaRepository.findDistinctByTexto();
    }

}
