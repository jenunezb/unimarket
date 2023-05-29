package co.edu.uniquindio.unimarket.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Producto producto;

    @ManyToOne
    @JsonIgnore
    private Compra compra;

}
