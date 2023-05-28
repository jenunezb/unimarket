package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
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
    private final ImagenController imagenController;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        productoServicio.crearProducto(productoDTO);
        productoDTO.setImagenes(imagenController.url);
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false,
                "el producto "+productoDTO.getNombre()+" se creo exitosamente") );
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO>listarProductos(){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductos()));
    }

    @GetMapping("/listarMod")
    public ResponseEntity<MensajeDTO>listarProductosModerador(){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductosModerador()));
    }

    @DeleteMapping("/{codigoProducto}")
    public  ResponseEntity<MensajeDTO>eliminarProducto(@PathVariable Integer codigoProducto){
        try{
            productoServicio.eliminarProducto(codigoProducto);
            return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, "producto eliminado exitosamente"));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MensajeDTO(HttpStatus.INTERNAL_SERVER_ERROR, true, "El producto no existe"));
        }
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable Integer codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.obtenerProducto(codigoProducto)));
    }

    @GetMapping("/categorias")
    public ResponseEntity<Categoria[]> getCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body( Categoria.values());
    }

    @GetMapping("/busqueda/{nombreProducto}")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@PathVariable String nombreProducto) {
        System.out.println(nombreProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductosNombre(nombreProducto)));
    }

    @GetMapping("misproductos/{correoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable String correoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductosUsuario(correoUsuario)));
    }

    @GetMapping("/estado/{codigoProducto}")
    public ResponseEntity <MensajeDTO>modificarproducto(@PathVariable Integer codigoProducto) throws Exception{
        productoServicio.modificarproducto(codigoProducto );
         return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, "producto modificado" ));
    }
}
