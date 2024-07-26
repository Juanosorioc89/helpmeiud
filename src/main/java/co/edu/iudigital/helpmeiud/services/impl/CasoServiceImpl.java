package co.edu.iudigital.helpmeiud.services.impl;


import co.edu.iudigital.helpmeiud.dtos.casos.CasoRequestDTO;
import co.edu.iudigital.helpmeiud.dtos.casos.CasoResponseDTO;
import co.edu.iudigital.helpmeiud.exceptions.ErrorDto;
import co.edu.iudigital.helpmeiud.exceptions.InternalServerErrorException;
import co.edu.iudigital.helpmeiud.exceptions.NotFoundException;
import co.edu.iudigital.helpmeiud.exceptions.RestException;
import co.edu.iudigital.helpmeiud.models.Caso;
import co.edu.iudigital.helpmeiud.models.Delito;
import co.edu.iudigital.helpmeiud.models.Usuario;
import co.edu.iudigital.helpmeiud.repositories.ICasoRepository;
import co.edu.iudigital.helpmeiud.repositories.IDelitoRepository;
import co.edu.iudigital.helpmeiud.repositories.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.services.ifaces.ICasoService;
import co.edu.iudigital.helpmeiud.utils.CasoMapper;
import co.edu.iudigital.helpmeiud.utils.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CasoServiceImpl implements ICasoService {
    @Autowired
    private CasoMapper casoMapper;
    @Autowired
    private ICasoRepository casoRepository;
    @Autowired
    private IDelitoRepository delitoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<CasoResponseDTO> consultarCasos() throws RestException {
       log.info("Consultar casos CasoServiceImpl");
       try {
            final List<Caso> casos = casoRepository.findAll();
            final List<CasoResponseDTO> casoResponseDTOList =
                    casoMapper.toCasoResponseDTOList(casos);
           return casoResponseDTOList;
       } catch (Exception e){
           log.error("Error consultando casos");
           throw new InternalServerErrorException(
                   ErrorDto.builder()
                           .error("Error general")
                           .status(500)
                           .build()
           );
       }
    }

    @Override
    public CasoResponseDTO guardarCaso(final CasoRequestDTO caso) throws RestException{
    log.info("Consultar casos casoServiceImp");
    final Delito delitoBD = delitoRepository.findById(caso.getDelitoId())
            .orElseThrow(() ->
                        new NotFoundException(
                        ErrorDto.builder()
                        .error(Messages.NO_ENCONTRADO)
                        .message(Messages.DELITO_NO_EXISTE)
                        .status(404)
                        .date(LocalDateTime.now())
                        .build())
                );
    final Usuario usuarioBD = usuarioRepository.findById(caso.getUsuarioId())
            .orElseThrow(() ->{
                log.warn("Error al consultar usuario {}");
                return new NotFoundException(
                        ErrorDto.builder()
                                .error("Usuario no encontrado")
                                .message("Usuario no existe")
                                .status(404)
                                .date(LocalDateTime.now())
                                .build());
            });
    try {
        Caso casoEntity = new Caso();
        casoEntity.setFechaHora(caso.getFechaHora());
        casoEntity.setAltitud(caso.getAltitud());
        casoEntity.setLatitud(caso.getLatitud());
        casoEntity.setLongitud(caso.getLongitud());
        casoEntity.setVisible(true);
        casoEntity.setDescripcion(caso.getDescripcion());
        casoEntity.setUrlMapa(caso.getUrlMapa());
        casoEntity.setRmiUrl(caso.getRmiUrl());
        casoEntity.setUsuario(usuarioBD);
        casoEntity.setDelito(delitoBD);
        casoEntity = casoRepository.save(casoEntity);
        return casoMapper.toCasoResponseDTO((casoEntity));
    } catch (Exception e){
        log.error("Error consultado caso: {}", e.getMessage());
        throw new InternalServerErrorException(
                ErrorDto.builder()
                        .error("Error general")
                        .status(500)
                        .message(e.getMessage())
                        .date(LocalDateTime.now())
                        .build()
        );

    }
    }


}
