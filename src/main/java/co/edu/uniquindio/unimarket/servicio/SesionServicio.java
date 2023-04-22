package co.edu.uniquindio.unimarket.servicio;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

    void logout(SesionDTO sesionDTO);

}
