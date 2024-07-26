package co.edu.iudigital.helpmeiud.dtos.usuarios;

import co.edu.iudigital.helpmeiud.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UsuarioRequestDTO {

    static final long serialVersionUID = 1L;

    @NotNull(message = "Username requerido")
    @Email(message = "Username debe ser email")
    String username;

    @NotNull(message = "Nombre requerido")
    String nombre;

    String apellido;

    String password;

    @JsonProperty("fecha de nacimiento")
    LocalDate fechaNacimiento;

    Boolean enable;

    Boolean redSocial;

    String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name =  "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    List<Role> roles;
}
