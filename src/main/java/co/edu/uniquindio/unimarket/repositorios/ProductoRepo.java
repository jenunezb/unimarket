package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.vendedor.email = :correoUsuario")
    List<Producto> listarProductosUsuario(String correoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' )")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p from Producto p")
    List<Producto> listarProductos();

}
