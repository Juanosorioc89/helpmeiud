package co.edu.iudigital.helpmeiud.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "delitos")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delito implements Serializable {

    static final long serialVersionIUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true, length = 120)
    String nombre;
    @Column(length = 255)
    String descripcion;
    @ManyToOne
    @JoinColumn (name="usuarios_id")
    Usuario usuario;

}