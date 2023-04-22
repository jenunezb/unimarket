package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Favorito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Usuario usuario;

}
