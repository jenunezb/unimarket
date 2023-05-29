package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
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
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    //@Column(nullable = false)
    private LocalDate fecha_creacion;

    @Column(nullable = false)
    private double valor_total;

    @Column(nullable = false)
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "compra")
    private List<Detalle_Compra> detalle_compras;

    @ManyToOne
    private Usuario usuario;
}
