package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.SesionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO dto) throws Exception;

    /*TokenDTO logout (SesionDTO dto) throws  Exception;*/

}