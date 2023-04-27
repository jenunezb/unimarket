package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Estado;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.AttributeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if(!estaDisponible(c.getEmail())){
            throw new AttributeException("El correo "+c.getEmail()+" ya está en uso");
        }
        Usuario cliente = new Usuario();
        cliente.setNombre( usuarioDTO.getNombre() );
        cliente.setEmail( usuarioDTO.getEmail());
        cliente.setDireccion( usuarioDTO.getDireccion() );
        cliente.setTelefono( usuarioDTO.getTelefono() );
        cliente.setPassword( usuarioDTO.encode(usuarioDTO.getPassword()) );
        return usuarioRepo.save( cliente ).getCedula();
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception{

/*
          TODO Validar que el correo no se repita
*/

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCedula(codigoUsuario);

        return convertir( usuarioRepo.save(usuario) );
    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception{
        return convertir( obtener(codigoUsuario) );
    }

    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    @Override
    public List<UsuarioGetDTO> listarTodos() {
        List<UsuarioGetDTO> convertidos= new ArrayList<>();
        for (Usuario usuario : usuarioRepo.findAll()) {
            convertidos.add(convertir(usuario));
        }
        return convertidos;
    }

    private void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }


    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( usuarioDTO.getPassword() );
        usuario.setCiudad( usuarioDTO.getCiudad());
        usuario.setEstado(Estado.INACTIVO);

        return usuario;
    }

}