package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MensajeDTO <T>{

    private String mensaje;
    private T dato;

    public MensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}