package co.edu.uniquindio.unimarket.controladores;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ModeradorDTO;
import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {

 private final SesionServicio sesionServicio;
 private final UsuarioServicio usuarioServicio;
 private final ModeradorServicio moderadorServicio;

 @PostMapping("/login")
 public ResponseEntity<MensajeDTO> iniciar(@RequestBody SesionDTO sesionDTO) throws Exception{
  System.out.println(sesionDTO.getEmail());
  if(sesionDTO.getEmail().equals("admin@gmail.com") && sesionDTO.getPassword().equals("1")){
   return ResponseEntity.status(HttpStatus.OK).body( new co.edu.uniquindio.unimarket.dto.MensajeDTO(HttpStatus.OK, false,"entra"));
  }else {
   return ResponseEntity.status(HttpStatus.OK).body( new co.edu.uniquindio.unimarket.dto.MensajeDTO(HttpStatus.OK, false,sesionServicio.login(sesionDTO)));
  }
 }
 @PostMapping("/registro")
 public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody UsuarioDTO cliente) throws Exception {
  usuarioServicio.crearUsuario(cliente);
  return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
          false, "Cliente creado correctamente"));
 }

 @PostMapping
 public ResponseEntity<MensajeDTO> registrarModerador(@Valid @RequestBody ModeradorDTO moderadorDTO) throws Exception {
  moderadorServicio.crearModerador(moderadorDTO);
  return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
          false, "Cliente creado correctamente"));
 }


}
