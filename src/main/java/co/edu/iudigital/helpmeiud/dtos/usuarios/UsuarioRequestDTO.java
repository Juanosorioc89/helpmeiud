package co.edu.iudigital.helpmeiud.dtos.usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UsuarioRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @NotNull(message = "Username requerido")
    @Email(message = "Username debe ser email")
    String username;

    @NotNull(message = "Nombre requerido")
    String nombre;

    String apellido;

    String password;

    @JsonProperty("fecha_nacimiento")
    LocalDate fechaNacimiento;

    @JsonIgnore
    Boolean enable;
    @JsonIgnore
    Boolean redSocial;

    String image;

    @JsonIgnore
    List<Long> roles;
}
