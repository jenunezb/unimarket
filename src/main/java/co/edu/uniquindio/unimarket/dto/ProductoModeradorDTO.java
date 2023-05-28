package co.edu.uniquindio.unimarket.dto;
import co.edu.uniquindio.unimarket.modelo.Activo;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoModeradorDTO {

        private int codigo;

        private LocalDateTime fechaLimite;

        private String nombre;

        private String descripcion;

        private int unidades;

        private float precio;

        private int codigoVendedor;

        private List<String> imagenes;

        private List<Categoria> categorias;

        private Activo estado;
    }

