package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.*;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
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
    private final DetalleCompraRepo detalleCompraRepo;

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
            double valor_total =0.0;

            for (DetalleCompraDTO detalleCompraDTO: compraDTO.getDetalleCompraDTO()) {

               detalleCompra.setPrecio(detalleCompraDTO.getPrecio());
               valor_total += detalleCompraDTO.getPrecio();
               detalleCompra.setUnidades(detalleCompraDTO.getUnidades());
               Optional<Producto> producto = compraRepo.findProducto(detalleCompraDTO.getCodigoProducto());
               detalleCompra.setProducto(producto.get());
               detalleCompra.setCompra(compra);
               detalle_compras.add(detalleCompra);
            }
            compra.setValor_total(valor_total);
            valor_total =0.0;
            compra.setDetalle_compras(detalle_compras);
        }
        compraRepo.save(compra);
        for (Detalle_Compra detalle_compra:detalle_compras) {
            detalle_compra.setCompra(compra);
            detalleCompraRepo.save(detalleCompra);
        }


    }



    @Override
    public List<CompraDTO> listarCompras(int codigoUsuario) {
        List<Compra> compras = compraRepo.listarCompras(codigoUsuario);
        CompraDTO compraDTO = new CompraDTO();
        List<CompraDTO> listarCompras = new ArrayList<>();
        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
        List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();

        for (Compra compra:   compras) {
            int data = compra.getUsuario().getCedula();
            compraDTO.setCodigoUsuario(data);
            compraDTO.setMetodoPago(compra.getMetodoPago());

            for (Detalle_Compra detalleCompra: compra.getDetalle_compras()) {
            detalleCompraDTO.setCodigoProducto(detalleCompra.getProducto().getCodigo());
            detalleCompraDTO.setPrecio((float) detalleCompra.getPrecio());
            detalleCompraDTO.setUnidades(detalleCompra.getUnidades());
            detalleCompraDTOS.add(detalleCompraDTO);
            }


            compraDTO.setDetalleCompraDTO(detalleCompraDTOS);
            listarCompras.add(compraDTO);

        }

        return listarCompras;
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