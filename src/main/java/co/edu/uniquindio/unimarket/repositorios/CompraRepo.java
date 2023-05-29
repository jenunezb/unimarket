package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select u from Usuario u where u.cedula = :cedula")
    Optional <Usuario> findUsuario(@Param("cedula") Integer cedula);

    @Query("select p from Detalle_Compra d  inner join Producto p on d.producto.codigo = p.codigo where p.codigo = :codigoProducto")
    Optional <Producto> findProducto(@Param("codigoProducto") Integer codigoProducto);
}
