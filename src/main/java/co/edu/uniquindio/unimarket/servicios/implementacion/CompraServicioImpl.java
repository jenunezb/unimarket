package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.*;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public void crearCompra(CompraDTO compraDTO) {
        Compra compra = new Compra();
        Optional<Usuario> usuario = compraRepo.findUsuario(compraDTO.getCodigoUsuario());

        Detalle_Compra detalleCompra = new Detalle_Compra();
        List<Detalle_Compra> detalle_compras = new ArrayList<>();



        if(usuario.isPresent()){
            compra.setUsuario(usuario.get());
            compra.setMetodoPago(compraDTO.getMetodoPago());
            compra.setFecha_creacion(LocalDate.now());

            for (DetalleCompraDTO detalleCompraDTO: compraDTO.getDetalleCompraDTO()) {

               detalleCompra.setPrecio(detalleCompraDTO.getPrecio());
               detalleCompra.setUnidades(detalleCompraDTO.getUnidades());
               Optional<Producto> producto = compraRepo.findProducto(detalleCompraDTO.getCodigoProducto());
               detalleCompra.setProducto(producto.get());
               detalle_compras.add(detalleCompra);
            }

            compra.setDetalle_compras(detalle_compras);
        }

        compraRepo.save(compra);
    }



    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Integer cedula) {
        return compraRepo.findUsuario(cedula);
    }


}