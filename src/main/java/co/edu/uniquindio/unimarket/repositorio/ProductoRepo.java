package co.edu.uniquindio.unimarket.repositorio;

import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.estado = 'true'")
    List<Producto> listarProductosNombre(String nombre);

}
