package co.edu.uniquindio.unimarket.servicio.interfaces;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

}
