package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.modelo.*;
import co.edu.uniquindio.unimarket.repositorios.FavoritoRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.FavoritoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoritoServicioImpl implements FavoritoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioRepo usuarioRepo;
    private final FavoritoRepo favoritoRepo;

    @Override
    public void existsByProductoAndUsuario(Integer codigoProducto, Integer codigoUsuario) throws Exception {

        Optional<Producto> productoOptional = productoRepo.findById(codigoProducto);
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(codigoUsuario);

        if (productoOptional.isPresent() && usuarioOptional.isPresent()) {
            Producto producto = productoOptional.get();
            Usuario usuario = usuarioOptional.get();

            boolean favoritoExistente = favoritoRepo.existsByProductoAndUsuario(producto, usuario);
            if (!favoritoExistente) {
                Favorito favorito = new Favorito();
                favorito.setProducto(producto);
                favorito.setUsuario(usuario);

                favoritoRepo.save(favorito);
            } else {
                throw new Exception("El producto ya se encuentra en los favoritos del usuario");
            }
        } else {
            throw new Exception("El producto o el usuario no existen");
        }
    }

    @Override
    public List<FavoritoDTO> listarProductos() {
        List<Favorito> lista = favoritoRepo.listarProductos();
        List<FavoritoDTO> respuesta = new ArrayList<>();
        for(Favorito p : lista){
            respuesta.add( convertir(p) );
        }
        return respuesta;
    }

    private FavoritoDTO convertir(Favorito producto){

        FavoritoDTO favoritoDTO = new FavoritoDTO(
                producto.getCodigo(),producto.getProducto().getCodigo()
        );
        return favoritoDTO;
    }

    @Override
    public void eliminarProducto(Integer codigo)throws Exception{
        System.out.println(codigo);
        favoritoRepo.deleteById(codigo);
    }
}