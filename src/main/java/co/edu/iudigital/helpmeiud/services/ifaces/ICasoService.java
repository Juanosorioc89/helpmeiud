package co.edu.iudigital.helpmeiud.services.ifaces;


import co.edu.iudigital.helpmeiud.dtos.casos.CasoRequestDTO;
import co.edu.iudigital.helpmeiud.dtos.casos.CasoResponseDTO;
import co.edu.iudigital.helpmeiud.exceptions.RestException;


import java.util.List;

public interface ICasoService {

    List<CasoResponseDTO> consultarCasos() throws RestException;

    CasoResponseDTO guardarCaso (CasoRequestDTO casoString) throws RestException;

}
