package co.edu.uniquindio.unimarket.repositorio;

import co.edu.uniquindio.unimarket.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.vendedor.cedula = :codigoUsuario")
    List<Producto> listarProductosUsuario(String codigoUsuario);

  /*  @Query("delete p from Producto p where p.nombre =:nombreProducto")
    Producto eliminarPorNombre(String nombreProducto);

   */

    @Query("select p from Producto p where p.nombre = :nombreProducto")
    List<Producto> listarProductoNombre(String nombreProducto);

}
