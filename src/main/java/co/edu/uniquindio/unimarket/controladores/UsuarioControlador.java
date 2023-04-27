package co.edu.uniquindio.unimarket.controladores;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
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
    public int registrar(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
            return usuarioServicio.crearUsuario(usuario);
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO("HttpStatus.OK, false", usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO)));
    }

    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminiarUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.eliminiarUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO("HttpStatus.OK, false", "Usuario eliminado correctamente") );
    }

    @GetMapping("/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO("HttpStatus.OK, false", usuarioServicio.obtenerUsuario(codigoUsuario)));
    }

    @GetMapping()
    public List<UsuarioGetDTO> listar()
    {
        return  usuarioServicio.listarTodos();
    }

}
