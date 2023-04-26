package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
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
    private double precio;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private LocalDate fecha_creado;

    @Column(nullable = false)
    private LocalDate fecha_limite;

    @ManyToOne
    private Usuario vendedor;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagen;

    @OneToMany(mappedBy = "producto")
    private List<Favorito> favoritos;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradores;

    @OneToMany(mappedBy = "producto")
    private List<Detalle_Compra> detalle_compras;

    public Producto( String nombre, int unidades, String descripcion, double precio, Estado estado, Categoria categoria, LocalDate fecha_creado, LocalDate fecha_limite) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
        this.fecha_creado = fecha_creado;
        this.fecha_limite = fecha_limite;
    }
}
