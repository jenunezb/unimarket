package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @PositiveOrZero
    @Column(nullable = false)
    private int unidades;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private float precio;
    
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Categoria> categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Activo activo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @ManyToOne
    private Usuario vendedor;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @ElementCollection
    @NotNull
    private List<String> imagenes;

    @Column(nullable = false)
    @OneToMany(mappedBy = "producto")
    private List<Favorito> favoritos;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradores;

    @OneToMany(mappedBy = "producto")
    private List<Detalle_Compra> detalle_compras;

    public Producto( String nombre, int unidades, String descripcion, float precio, List<Categoria> categoria, LocalDateTime fechaCreacion, LocalDateTime fechaLimite, Activo activo) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.activo = activo;
    }
}
