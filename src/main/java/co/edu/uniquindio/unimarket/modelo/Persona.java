package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
