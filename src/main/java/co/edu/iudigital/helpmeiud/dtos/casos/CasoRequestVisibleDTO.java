package co.edu.iudigital.helpmeiud.dtos.casos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CasoRequestVisibleDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @NotNull(message = "visible requerir")
    @JsonProperty("visible")
    Boolean visible;


}
