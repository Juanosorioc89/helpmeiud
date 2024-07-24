package co.edu.iudigital.helpmeiud.dtos.casos;


import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CasoRequestDTO {

    LocalDateTime fechaHora;

    Float latitud;

    Float longitud;

    Float altitud;

    Boolean visible;

    String descripcion;

    String urlMapa;

    String rmiUrl;

    String username;

    Long delitoId;
}
