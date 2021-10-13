package com.example.apitreeeco.repositories;

import com.example.apitreeeco.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(" SELECT DISTINCT servicio.categoria FROM Servicio servicio")
    List<String> findDistinctByCategoria();

    List<Servicio>findDistinctByNombreContaining(String nombre);

    List<Servicio>findByCategoria(String categoria);

    List<Servicio> findServiciosByPuntosBetween(Integer puntosDesde, Integer puntosHasta);

    List<Servicio> findDistinctByCategoriaContaining(String categoria);
}
