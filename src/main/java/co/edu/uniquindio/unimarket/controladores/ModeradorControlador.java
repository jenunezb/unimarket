package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ModeradorDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearModerador(@RequestBody ModeradorDTO moderadorDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO("Moderador creado exitosamente",  moderadorServicio.crearModerador(moderadorDTO)) );
    }
}