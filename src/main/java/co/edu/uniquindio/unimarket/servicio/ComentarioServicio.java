package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.DTO.ComentarioDTO;
import co.edu.uniquindio.unimarket.DTO.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentario(int codigoProducto);

}
