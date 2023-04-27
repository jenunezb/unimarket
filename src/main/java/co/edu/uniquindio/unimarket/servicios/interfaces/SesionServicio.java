package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.SesionDTO;

public interface SesionServicio {

    void login(SesionDTO dto) throws Exception;

    void logout(int codigoUsuario) throws Exception;

}
