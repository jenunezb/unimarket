package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Moderador;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {

    @Query("select u from Usuario u where u.cedula = :cedula")
    Moderador buscarModerador(@Param("cedula") Integer cedula);

    @Query("select u from Usuario u where u.email = :email")
    Optional<Moderador> findByEmail(@Param("email") String email);

}
