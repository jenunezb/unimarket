package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.Imagen;
import co.edu.uniquindio.unimarket.modelo.Mensaje;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/imagenes")
@AllArgsConstructor
public class ImagenController {

    private CloudinaryServicio cloudinaryServicio;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws Exception {
        File file=cloudinaryServicio.convertir(multipartFile);
        if(file == null){
            return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, "error al subir la imagen") );
        }
        cloudinaryServicio.subirImagen(file,"unimarket");
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, " la imagen subió") );
    }

}
