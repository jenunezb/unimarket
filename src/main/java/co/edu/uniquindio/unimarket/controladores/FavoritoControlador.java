package co.edu.uniquindio.unimarket.controladores;
import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favoritos")
@AllArgsConstructor
public class FavoritoControlador {

        private final FavoritoServicio favoritoServicio;

        @PostMapping("/crear")
        public ResponseEntity<MensajeDTO> agregarFav(@RequestBody FavoritoDTO favoritoDTO) throws Exception {
            favoritoServicio.agregarFavorito(favoritoDTO.getCodigoProducto(), favoritoDTO.getCodigoUsuario());
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false,
                    "El producto se agregó a favoritos exitosamente"));
        }
    }
