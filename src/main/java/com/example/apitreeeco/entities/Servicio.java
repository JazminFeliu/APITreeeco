package com.example.apitreeeco.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Integer ServicioId;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Integer puntos;
    private Double cantidad;
    private Double precio;
    private String unidad;

    public Servicio() {
    }

    public Servicio(Integer servicioId, String nombre, String descripcion, String categoria, Integer puntos, Double cantidad, Double precio, String unidad) {
        ServicioId = servicioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
    }

    public Servicio(String nombre, String descripcion, String categoria, Integer puntos, Double cantidad, Double precio, String unidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
    }

    public Integer getServicioId() {
        return ServicioId;
    }

    public void setServicioId(Integer servicioId) {
        ServicioId = servicioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
