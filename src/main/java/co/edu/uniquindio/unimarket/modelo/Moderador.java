package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Moderador {

    @EqualsAndHashCode.Include
    @Id
    private String codigo;

}
