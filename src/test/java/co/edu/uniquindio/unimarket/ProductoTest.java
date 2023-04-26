package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Estado;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Producto producto = new Producto("nombre", 5, "descripcion", 2500, Estado.INACTIVO, Categoria.ROPA, LocalDate.now(),LocalDate.now());
        Producto productoGuardado = productoRepo.save(producto);
        Assertions.assertNotNull(productoGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
            List<Producto> productos = productoRepo.listarProductos();
            System.out.println(productos);
            Assertions.assertNotNull(productos);
    }

    /**@Test
    @Sql("classpath:dataset.sql")
    public void buscar(){
        List<Producto> productoBuscado = productoRepo.listarProductosUsuario("085");
        Assertions.assertNotNull(productoBuscado);
    }
     **/

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
       Producto producto = productoRepo.findById(1).orElse(null);
       try {
           productoRepo.delete(producto);
       }catch (Exception exception){
           System.out.println("no encuentra el producto");
       }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Producto producto = productoRepo.findById(1).orElse(null);
        try {
            producto.setNombre("otro nombre");
            productoRepo.save(producto);
        }catch (Exception exception){
            System.out.println("no encuentra el producto");
        }
    }
}
