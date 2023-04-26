package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)

public class Usuario extends Persona implements Serializable {

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

    public Usuario(int codigo, String nombre, @Email String email, String password) {
        super(codigo, nombre, email, password);
    }
}
