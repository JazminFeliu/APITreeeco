package com.example.apitreeeco.repositories;

import com.example.apitreeeco.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT DISTINCT producto.categoria FROM Producto producto")
    List<String> findDistinctByCategoria();

    List<Producto>findDistinctByNombreContaining(String nombre);

    List<Producto> findByCategoria(String categoria);

    List<Producto> findProductosByPuntosBetween(Integer puntosDesde, Integer puntosHasta);

    List<Producto> findDistinctByCategoriaContaining(String categoria);

}
