package com.example.apitreeeco.services;

import com.example.apitreeeco.entities.Servicio;
import com.example.apitreeeco.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getServicios(){
        return servicioRepository.findAll();
    }

    public Servicio save(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    public List<Servicio>getServicioByServicioId(String servicioId){
        Integer id;
        try {
            id = Integer.parseInt(servicioId);
        }catch (NumberFormatException e){
            id = 0;
        }
        return servicioRepository.findAllById(List.of(id));
    }

    public void deleteById(Integer id){
        servicioRepository.deleteById(id);
    }

    public List<String>getCategorias(){
        return servicioRepository.findDistinctByCategoria();
    }

    public List<Servicio>findByNombreContaining(String nombre){
        return servicioRepository.findDistinctByNombreContaining(nombre);
    }

    public List<Servicio>findByCategoria(String categoria){
        return servicioRepository.findByCategoria(categoria);
    }

    public List<Servicio>findServiciosByPuntosBetween(Integer puntosDesde, Integer puntosHasta){
        return servicioRepository.findServiciosByPuntosBetween(puntosDesde,puntosHasta);
    }

    public List<Servicio> findByCategoriaContaining(String categoria){
        return servicioRepository.findDistinctByCategoriaContaining(categoria);
    }
}
