package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.MetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metodoPago")
@AllArgsConstructor
public class MetodoPagoController {

    @GetMapping
    public ResponseEntity<MetodoPago[]> getMetodoPago() {
        return ResponseEntity.status(HttpStatus.OK).body( MetodoPago.values());
    }
}
