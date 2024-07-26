package co.edu.iudigital.helpmeiud.controllers;

import co.edu.iudigital.helpmeiud.dtos.casos.CasoRequestDTO;
import co.edu.iudigital.helpmeiud.dtos.casos.CasoResponseDTO;
import co.edu.iudigital.helpmeiud.exceptions.RestException;

import co.edu.iudigital.helpmeiud.services.ifaces.ICasoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private ICasoService casoService;

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "500", description = "Internal Error Server")
            }
    )
    @Operation(
            summary = "Crear un caso",
            description = "Endpoint para crear un caso"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CasoResponseDTO> create(@RequestBody CasoRequestDTO caso) throws RestException {
        log.info("Ejecutando create casoController");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(casoService.guardarCaso(caso));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @Operation(
            summary = "Consultar todos los casos",
            description ="Endpoint para consultar todos los delitos"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<CasoResponseDTO>> index() throws RestException {
        log.info("Ejecutando index de casoController");
        return ResponseEntity.status(HttpStatus.OK).body(casoService.consultarCasos());
    }

}
