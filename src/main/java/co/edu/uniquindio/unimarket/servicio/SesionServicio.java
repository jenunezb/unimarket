package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.DTO.SesionDTO;
import co.edu.uniquindio.unimarket.DTO.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

    void logout(SesionDTO sesionDTO);

}
