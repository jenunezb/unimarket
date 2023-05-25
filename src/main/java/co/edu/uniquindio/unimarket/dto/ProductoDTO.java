package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @Length(max = 140)
    @NotBlank
    @NotNull
    private String nombre;

    @NotBlank
    @NotNull
    private String descripcion;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private float precio;

    @Positive
    private int codigoVendedor;

    @NotNull
    private List<String> imagenes;

    @NotNull
    private List<Categoria> categoria;
}
