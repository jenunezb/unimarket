package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorio.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrar(){
        Usuario usuario = new Usuario(1, "Usuario de testeo", "correo@gmail.com", "password");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminar(){
        Usuario usuario = new Usuario(1, "Usuario de testeo", "correo@gmail.com", "password");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuarioGuardado);

       Usuario usuarioBuscado = usuarioRepo.findById(1).orElse(null);

        Assertions.assertNull(usuarioBuscado);

    }

    @Test
    public void actualizar(){
        Usuario usuario = new Usuario(1, "Usuario de testeo", "correo@gmail.com", "password");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioGuardado.setPassword("otro");

        usuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById(1).orElse(null);
        Assertions.assertEquals("otro", usuarioBuscado.getPassword());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void listar(){
        List<Usuario> usuarios = usuarioRepo.findAll();

        System.out.println(usuarios);

    }

}
