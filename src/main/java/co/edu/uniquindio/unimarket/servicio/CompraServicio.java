package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import java.util.List;

public interface CompraServicio {

    //int crearCompra(CompraDTO);

    List<CompraGetDTO> listarCompraUsuario(int codigoUsuario);


}
