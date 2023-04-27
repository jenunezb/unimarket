package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ModeradorDTO;

public interface ModeradorServicio {

    int crearModerador(ModeradorDTO moderadorDTO) throws Exception;

   // int eliminarModerador(int codigoModerador, ModeradorDTO moderadorDTO) throws Exception;
}
