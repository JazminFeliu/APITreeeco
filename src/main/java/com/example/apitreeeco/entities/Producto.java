package com.example.apitreeeco.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Integer producto_id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Integer puntos;
    private Integer cantidad;
    private Integer precio;
    private String unidad;

    public Producto() {
    }

    public Producto(Integer producto_id, String nombre, String descripcion, String categoria, Integer puntos, Integer cantidad, Integer precio, String unidad) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
    }

    public Producto(String nombre, String descripcion, String categoria, Integer puntos, Integer cantidad, Integer precio, String unidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer productoId) {
        this.producto_id = productoId;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
