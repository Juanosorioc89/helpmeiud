package co.edu.iudigital.helpmeiud.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "usuarios")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Usuario implements Serializable {

    static final long serialVersionIUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true, length = 120)
    String username;
    @Column(length = 120, nullable = false)
    String nombre;
    @Column(length = 120)
    String apellido;
    @Column
    String password;
    @Column(name= "fecha_nacimiento")
    LocalDate fechaNacimiento;
    @Column
    Boolean enable;
    @Column(name= "red_social")
    Boolean redSocial;
    @Column
    String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name =  "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    List<Role> roles;

}
