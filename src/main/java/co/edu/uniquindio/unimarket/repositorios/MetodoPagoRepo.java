package co.edu.uniquindio.unimarket.repositorios;


import co.edu.uniquindio.unimarket.modelo.MetodoPago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetodoPagoRepo {

    @Query("select m from MetodoPago m")
    List<MetodoPago> listarMetodosPago() throws Exception;
}
