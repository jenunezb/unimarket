package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Favorito;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepo extends JpaRepository<Favorito, Integer> {

    Favorito save(Favorito favorito);

    boolean existsByProductoAndUsuario (Producto producto, Usuario usuario);

    @Query("select f from Favorito f")
    List<Favorito> listarProductos();

    @Query("delete from Favorito f where f.producto=:codigo")
    void eliminarProducto(Integer codigo);
}
