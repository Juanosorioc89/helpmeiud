package co.edu.iudigital.helpmeiud.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Table(name = "roles")
public class Role implements Serializable {

    static final long serialVersionIUD = 1L;

    public Role(){

    }

    public Role(Long id){
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true, length = 100)
    String nombre;
    @Column
    String descripcion;
    @ManyToMany(mappedBy = "roles")
    List<Usuario> Usuario;

}