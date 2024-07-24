package co.edu.iudigital.helpmeiud.services.impl;


import co.edu.iudigital.helpmeiud.dtos.casos.CasoResponseDTO;
import co.edu.iudigital.helpmeiud.exceptions.ErrorDto;
import co.edu.iudigital.helpmeiud.exceptions.InternalServerErrorException;
import co.edu.iudigital.helpmeiud.exceptions.RestException;
import co.edu.iudigital.helpmeiud.models.Caso;
import co.edu.iudigital.helpmeiud.repositories.ICasoRepository;
import co.edu.iudigital.helpmeiud.services.ifaces.ICasoService;
import co.edu.iudigital.helpmeiud.utils.CasoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CasoServiceImpl implements ICasoService {
    @Autowired
    private CasoMapper casoMapper;
    @Autowired
    private ICasoRepository casoRepository;
    @Override
    public List<CasoResponseDTO> consultarCasos() throws RestException {
       log.info("Consultar casos CasoServiceImpl");
       try {
            final List<Caso> casos = casoRepository.findAll();
            final List<CasoResponseDTO> casoResponseDTOList =
                    casoMapper.toCasoResponseDTOList(casos);
           return casoResponseDTOList;
       } catch (Exception e){
           throw new InternalServerErrorException(
                   ErrorDto.builder()
                           .error("Error general")
                           .status(500)
                           .build()
           );
       }
    }

}
