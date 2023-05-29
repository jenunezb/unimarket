package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;

import java.util.List;

public interface FavoritoServicio {

      void existsByProductoAndUsuario(Integer codigoProducto, Integer codigoUsuario) throws Exception;
      List<FavoritoDTO> listarProductos();
}

