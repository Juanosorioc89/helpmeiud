package co.edu.iudigital.helpmeiud.services.impl;

import co.edu.iudigital.helpmeiud.models.Delito;
import co.edu.iudigital.helpmeiud.repositories.IDelitoRepository;
import co.edu.iudigital.helpmeiud.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DelitoServiceimpl implements IDelitoService {

    @Autowired
    private IDelitoRepository delitoRepository;
    @Transactional
    @Override
    public Delito crearDelito(Delito delito) {
        return delitoRepository.save(delito);
    }
    @Transactional
    @Override
    public Delito actualizarDelitoPorID(Long id, Delito delito) {
        Delito delitoBD = delitoRepository.findById(id).orElseThrow(RuntimeException::new);
        delitoBD.setNombre(delito.getNombre());
        delitoBD.setDescripcion(delito.getDescripcion());
        delitoBD.setUsuario(delito.getUsuario());
        return delitoRepository.save(delitoBD);
    }
    @Transactional
    @Override
    public void eliminarDelitoPorID(Long id) {
        delitoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Delito consultarDelitosPorID(Long id) {
        return delitoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Delito> consultarDelitos() {
        return delitoRepository.findAll();
    }
}
