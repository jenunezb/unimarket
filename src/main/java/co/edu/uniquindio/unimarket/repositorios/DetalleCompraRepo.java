package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.Detalle_Compra;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DetalleCompraRepo extends JpaRepository<Detalle_Compra, Integer> {

    @Query("select u from Usuario u where u.cedula = :cedula")
    Optional <Usuario> findUsuario(@Param("cedula") Integer cedula);

    @Query("select p from Producto p where p.codigo = :codigoProducto")
    Optional <Producto> findProducto(@Param("codigoProducto") Integer codigoProducto);

    @Query("select c from Compra c inner join Usuario u on c.usuario.cedula = u.cedula where u.cedula =:cedula")
    List<Compra> listarCompras(@Param("cedula") Integer cedula);
}
