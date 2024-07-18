package co.edu.iudigital.helpmeiud.services.ifaces;

import co.edu.iudigital.helpmeiud.models.Delito;

import java.util.List;


public interface IDelitoService {

    Delito crearDelito(Delito delito);
    Delito actualizarDelitoPorID(Long id, Delito delito);

    void eliminarDelitoPorID(Long id);

    Delito consultarDelitosPorID(Long id);

    List<Delito> consultarDelitos();


}
