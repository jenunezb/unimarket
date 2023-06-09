package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Estado;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    int actualizarEstado(int codigoProducto, Estado estado) throws Exception;

    void eliminarProducto(Integer codigoProducto) throws Exception;

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(String correoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombreProducto);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

    List<ProductoGetDTO> listarProductos();

    List<ProductoModeradorDTO>listarProductosModerador();

    void modificarproducto(Integer codigoProducto) throws Exception;

    void modificarproductoU(Integer codigoProducto, ProductoDTO productoDTO) throws Exception ;
}
