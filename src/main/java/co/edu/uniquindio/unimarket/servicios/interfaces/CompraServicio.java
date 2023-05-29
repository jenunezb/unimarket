package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface CompraServicio {

    //int crearCompra(CompraDTO compraDTO);
    void crearCompra(CompraDTO compraDTO);

    List<CompraDTO> listarCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);

    Optional<Usuario> obtenerUsuario(Integer cedula);

}
