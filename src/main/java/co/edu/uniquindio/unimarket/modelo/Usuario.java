package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Usuario extends Persona implements Serializable {

    @Id
    @Column(length = 10)
    private String cedula;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "vendedor")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

}
