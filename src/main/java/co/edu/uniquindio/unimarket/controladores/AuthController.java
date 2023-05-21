package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ModeradorDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {

 private final ModeradorServicio moderadorServicio;

 @PostMapping("/registro")
 public ResponseEntity<MensajeDTO> iniciar() throws Exception{
  return ResponseEntity.status(HttpStatus.OK).body( new co.edu.uniquindio.unimarket.dto.MensajeDTO(HttpStatus.OK, false," Entra"));
 }
}
