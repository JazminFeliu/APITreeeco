package com.example.apitreeeco.repositories;

import com.example.apitreeeco.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query("SELECT DISTINCT consulta.nombre FROM Consulta consulta")
    List<String> findDistinctByNombre();

    @Query("SELECT DISTINCT consulta.apellido FROM Consulta consulta")
    List<String> findDistinctByApellido();

    @Query("SELECT DISTINCT consulta.email FROM Consulta consulta")
    List<String> findDistinctByEmail();

    @Query("SELECT DISTINCT consulta.telefono FROM Consulta consulta")
    List<String> findDistinctByTelefono();

    @Query("SELECT DISTINCT consulta.texto FROM Consulta consulta")
    List<String> findDistinctByTexto();

    List<Consulta> findDistinctByNombreContaining(String nombre);

    List<Consulta> findDistinctByApellidoContaining(String apellido);

    List<Consulta> findDistinctByEmailContaining(String email);

    List<Consulta> findDistinctByTelefonoContaining(String telefono);









}
