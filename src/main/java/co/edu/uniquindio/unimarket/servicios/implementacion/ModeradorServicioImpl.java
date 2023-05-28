package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ModeradorDTO;
import co.edu.uniquindio.unimarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Moderador;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    private final ModeradorRepo moderadorRepo;

    @Override
    public  int crearModerador(ModeradorDTO moderadorDTO) throws  Exception{

        Moderador buscado = moderadorRepo.buscarModerador(moderadorDTO.getCedula());

        if(buscado!=null){
            throw new Exception("El usuario ya está en uso");
        }
        Moderador moderador = convertir(moderadorDTO);
        return  moderadorRepo.save(moderador).getCedula();
    }

    private ModeradorGetDTO convertir(Moderador moderador){

        ModeradorGetDTO moderadorDTO = new ModeradorGetDTO(moderador.getCedula(),
        moderador.getNombre(),moderador.getEmail());

        return moderadorDTO;
    }

    private Moderador convertir(ModeradorDTO moderadorDTO){

        Moderador moderador = new Moderador();
        moderador.setCedula(moderadorDTO.getCedula());
        moderador.setNombre( moderadorDTO.getNombre() );
        moderador.setEmail( moderadorDTO.getEmail() );
        moderador.setPassword( passwordEncoder.encode(moderadorDTO.getPassword()) );

        return moderador;
    }

    @Override
    public List<ModeradorGetDTO> listarTodos() {
        List<ModeradorGetDTO> convertidos= new ArrayList<>();
        for (Moderador moderador : moderadorRepo.findAll()) {
            convertidos.add(convertir(moderador));
        }
        return convertidos;
    }

}
