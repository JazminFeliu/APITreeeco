package com.example.apitreeeco.services;

import com.example.apitreeeco.entities.Producto;
import com.example.apitreeeco.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto>getProductoByProductoId(String productoId){
        Integer id;
        try {
            id = Integer.parseInt(productoId);
        }catch (NumberFormatException e){
            id = 0;
        }
        return productoRepository.findAllById(List.of(id));
    }

    public void deleteById(Integer id){
        productoRepository.deleteById(id);
    }

    public List<String>getCategorias(){
        return productoRepository.findDistinctByCategoria();
    }

    public List<Producto> findByNombreContaining(String nombre){
        return productoRepository.findDistinctByNombreContaining(nombre);
    }


    public List<Producto> findByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> findProductosByPuntosBetween(Integer puntosDesde, Integer puntosHasta) {
        return productoRepository.findProductosByPuntosBetween(puntosDesde, puntosHasta);
    }

    public List<Producto> findByCategoriaContaining(String categoria) {
        return productoRepository.findDistinctByCategoriaContaining(categoria);
    }
}
