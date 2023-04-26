package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.modelo.Ciudad;
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
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Usuario usuario = new Usuario("10949245","Julián","gaspd@gmail.com","hila","vaidga","4785400",Ciudad.BARRANQUILLA);
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Usuario usuario = new Usuario("10949245","Julián","gaspd@gmail.com","hila","vaidga","4785400",Ciudad.BARRANQUILLA);
        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        usuarioRepo.delete(usuarioGuardado);
        Usuario usuarioBuscado = usuarioRepo.findByCedula("10949245");
        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Usuario usuario = new Usuario("1","Julián","gaspd@gmail.com","hila","vaidga","4785400",Ciudad.BARRANQUILLA);
        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        usuarioGuardado.setPassword("otro");
        usuarioRepo.save(usuarioGuardado);
        Usuario usuarioBuscado = usuarioRepo.findByCedula("1");
        Assertions.assertEquals("otro", usuarioBuscado.getPassword());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        System.out.println(usuarios);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar(){
        Usuario usuario = usuarioRepo.findByCedula("001");
        System.out.println(usuario);
    }

}
