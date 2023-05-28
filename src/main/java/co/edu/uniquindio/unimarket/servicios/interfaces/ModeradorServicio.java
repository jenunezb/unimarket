package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ModeradorDTO;
import co.edu.uniquindio.unimarket.dto.ModeradorGetDTO;

import java.util.List;

public interface ModeradorServicio {
    int crearModerador(ModeradorDTO moderadorDTO) throws Exception;
    List<ModeradorGetDTO> listarTodos();
}
