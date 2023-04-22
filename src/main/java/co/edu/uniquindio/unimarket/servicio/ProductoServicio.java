package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Estado;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO);

    int eliminarProducto(int codigoProducto);

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);

    int actualizarProductoPorEstado(int codigoProducto, Estado estado);

    int actualizarProductoPorCantidad(int codigoProducto, int unidades);

    ProductoGetDTO obtenerProducto(int codigoProducto);

    List<ProductoGetDTO> listarProductorCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosEstado(Estado estado);

    List<ProductoGetDTO>listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax);

    List<ProductoGetDTO>listarFavoritosUsuario(int codigoUsuario);

}
