package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> crearCompra(@Valid @RequestBody CompraDTO compra) throws Exception {
        compraServicio.crearCompra(compra);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false," compra creada exitosamente"));
    }

    @GetMapping("/listar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO>listarCompras(@PathVariable Integer codigoUsuario){
        compraServicio.listarCompras(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, compraServicio.listarCompras(codigoUsuario)));
    }
}
