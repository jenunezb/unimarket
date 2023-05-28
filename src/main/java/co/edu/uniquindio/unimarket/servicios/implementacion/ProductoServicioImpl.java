package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoModeradorDTO;
import co.edu.uniquindio.unimarket.modelo.*;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();

        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setVendedor( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ) );
        producto.setImagenes( productoDTO.getImagenes() );
        producto.setCategoria( productoDTO.getCategoria() );
        producto.setActivo( Activo.INACTIVO );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception{
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception{
        return 0;
    }

    @Override
    public void eliminarProducto(Integer codigoProducto) throws Exception{
        if (codigoProducto != null) {
            Optional<Producto> productoOptional = productoRepo.findById(codigoProducto);
            if (productoOptional.isPresent()) {
                productoRepo.deleteById(codigoProducto);
            } else {
                throw new Exception("El producto no existe");
            }
        } else {
            throw new IllegalArgumentException("El código del producto no puede ser nulo");
        }
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{
        Optional<Producto> productoOptional = productoRepo.findById(codigoProducto);
        if (productoOptional.isPresent()) {
            return convertir(productoOptional.get());
        } else {
            throw new Exception("El producto con el código " + codigoProducto + " no fue encontrado");
        }
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(String correoUsuario) {

        List<Producto> lista = productoRepo.listarProductosUsuario(correoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),producto.getFechaLimite(),
                producto.getNombre(), producto.getDescripcion(), producto.getUnidades(),
                producto.getPrecio(),producto.getVendedor().getCedula(),producto.getImagenes(),
                producto.getCategoria()
        );

        return productoGetDTO;
    }

    private ProductoModeradorDTO convertirParaMod(Producto producto){

        ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO(
                producto.getCodigo(),producto.getFechaLimite(),producto.getNombre(),
                producto.getDescripcion(), producto.getUnidades(),
                producto.getPrecio(),producto.getVendedor().getCedula(),producto.getImagenes(),
                producto.getCategoria(),producto.getActivo());

        return productoModeradorDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombreProducto) {

        List<Producto> lista = productoRepo.listarProductosNombre(nombreProducto);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductos() {
        List<Producto> lista = productoRepo.listarProductosUsuario();
        List<ProductoGetDTO> respuesta = new ArrayList<>();
        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }
        return respuesta;
    }

    public void modificarproducto(Integer codigoProducto) throws Exception {
        Optional<Producto> productoOptional = productoRepo.findById(codigoProducto);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            if(producto.getActivo()==Activo.INACTIVO){
                producto.setActivo(Activo.ACTIVO);
            }else {
                producto.setActivo(Activo.INACTIVO);
            }

            productoRepo.save(producto);
        } else {
            throw new Exception("El producto con el código " + codigoProducto + " no existe");
        }
    }

    @Override
    public List<ProductoModeradorDTO> listarProductosModerador() {

        List<Producto> lista = productoRepo.listarProductos();
        List<ProductoModeradorDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertirParaMod(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }
}