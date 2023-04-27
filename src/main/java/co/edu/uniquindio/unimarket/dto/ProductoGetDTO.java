package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Estado;
import co.edu.uniquindio.unimarket.modelo.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int codigo;

    private Estado estado;

    private LocalDateTime fechaLimite;

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    private List<Imagen> imagenes;

    private List<Categoria> categorias;
}
