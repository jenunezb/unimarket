package co.edu.uniquindio.unimarket.controladores;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {

 private final SesionServicio sesionServicio;

 @PostMapping("/login")
 public ResponseEntity<MensajeDTO> iniciar(@RequestBody SesionDTO sesionDTO) throws Exception{
  return ResponseEntity.status(HttpStatus.OK).body( new co.edu.uniquindio.unimarket.dto.MensajeDTO(HttpStatus.OK, false,sesionServicio.login(sesionDTO)));
 }

}
