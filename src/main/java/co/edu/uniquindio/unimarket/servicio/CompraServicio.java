package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.DTO.CompraGetDTO;
import java.util.List;

public interface CompraServicio {

    //int crearCompra(CompraDTO);

    List<CompraGetDTO> listarCompraUsuario(int codigoUsuario);


}
