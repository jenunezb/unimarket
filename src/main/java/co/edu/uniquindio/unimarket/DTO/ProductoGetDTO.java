package co.edu.uniquindio.unimarket.DTO;

import co.edu.uniquindio.unimarket.modelo.Categoria;

import java.time.LocalDateTime;
import java.util.List;

public class ProductoGetDTO {

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    private List<String> imagenes;

    private List<Categoria> categorias;

    private int codigo;

    private LocalDateTime fechaLimite;

    private  boolean activo;

    private LocalDateTime fechaPublicacion;

}
