package co.edu.iudigital.helpmeiud.dtos.casos;


import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CasoRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

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

    Long usuarioId;
}
