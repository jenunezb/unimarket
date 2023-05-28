package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.Ciudad;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> registrar(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
        usuarioServicio.crearUsuario(usuario);
       return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false," usuario "+usuario.getNombre()+" Creado exitosamente"));
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO)));
    }

    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int codigoUsuario) throws Exception {
        usuarioServicio.eliminarUsuario(codigoUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, "Usuario eliminado correctamente"));
    }

    @GetMapping("/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigoUsuario)));
    }

    @GetMapping()
    public List<UsuarioGetDTO> listar()
    {
        return  usuarioServicio.listarTodos();
    }

    @GetMapping("/ciudades")
    public ResponseEntity<Ciudad[]> getCiudades() {
        return ResponseEntity.status(HttpStatus.OK).body( Ciudad.values());
    }

    @GetMapping("cedula/{emailUsuario}")
    public ResponseEntity<MensajeDTO> cedulaUsuario(@PathVariable String emailUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.cedulaUsuario(emailUsuario)));
    }

}
