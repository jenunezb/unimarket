package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, productoServicio.crearProducto(productoDTO)) );
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO>listarProductos()throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductos()));
    }
}
