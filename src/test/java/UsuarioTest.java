import co.edu.uniquindio.unimarket.servicio.UsuarioServicio;


@SpringBootTest
@Transactional
public class UsuarioTest {


    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void sumarTest(){
        int resultado = usuarioServicio.sumar(a: 4, b: 10);


        //todos los test deben de llevar assertions
        Assertions.assertEquals(expected:14, resultado);

    }

    @Test
    public void crearUsuarioTest() throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO(nombre:"Pepito 1", email: "pepe1@gmail.com", password:"123");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        Assertions.assertNotEquals(unexpected:0, codigo);

    }

    @Test
    public void eliminarUsuarioTest()throws Exception{
        try{
            usuarioDTO usuarioDTO = new UsuarioDTO(nombre:"Pepito 1", email: "pepe1@gmail.com", password:"123");
            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            int codigoBorrado = usuarioServicio.eliminarUsuario(codigo);

            Assertions.assertEquals(codigoBorrado, codigo);
        }
    }

    @Test
    //Este codigo hay que cambiarlo todo
    public void actualizarUsuarioTest()throws Exception{
        try{
            usuarioDTO usuarioDTO = new UsuarioDTO(nombre:"Pepito 1", email: "pepe1@gmail.com", password:"123");
            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            int codigoBorrado = usuarioServicio.eliminarUsuario(codigo);

            Assertions.assertEquals(codigoBorrado, codigo);
        }
    }

    @Test
    //Obtener usuario test
    public void obtenerUsuarioTest() throws Exception{
        try{
            Usuario
        }catch (){

        }
    }

}
