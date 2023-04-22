package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;

public interface UsuarioServicio {

    int registrarUsuario(UsuarioDTO usuarioDTO);

    int actualizarUsuario(int codigo, UsuarioDTO usuarioDTO);

    UsuarioGetDTO obtenerUsuario(int codigo);
}
