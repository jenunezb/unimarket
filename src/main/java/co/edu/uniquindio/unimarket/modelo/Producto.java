package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Producto implements Serializable {

    @Id
    private String codigo;
}
