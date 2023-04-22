package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Moderador extends Persona implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private int codigo;

}
