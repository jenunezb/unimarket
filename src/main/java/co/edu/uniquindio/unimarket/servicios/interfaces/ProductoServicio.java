package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Estado;

import java.util.List;

public interface ProductoServicio {


    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    int actualizarEstado(int codigoProducto, Estado estado) throws Exception;

    int eliminarProducto(int codigoProducto) throws Exception;

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

    List<ProductoGetDTO> listarProductos();
}
