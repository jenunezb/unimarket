package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Moderador;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {

    @Query("select u from Usuario u where u.cedula = :cedula")
    Moderador buscarModerador(@Param("cedula") Integer cedula);

}
