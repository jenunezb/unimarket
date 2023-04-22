package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Detalle_Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Compra compra;

}
