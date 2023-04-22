package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.Categoria;

import java.util.List;

public class ProductoDTO {

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    private List<String> imagenes;

    private List<Categoria> categorias;

}
