package co.edu.iudigital.helpmeiud.controllers;

import co.edu.iudigital.helpmeiud.models.Delito;
import co.edu.iudigital.helpmeiud.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    public IDelitoService delitoService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Delito>save(@Valid @RequestBody Delito delito){
        return ResponseEntity.status(HttpStatus.CREATED).body(delitoService.crearDelito(delito));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Delito>update(@RequestBody Delito delito, @PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(delitoService.actualizarDelitoPorID(id, delito));

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        delitoService.eliminarDelitoPorID(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Delito>getOne(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(delitoService.consultarDelitosPorID(id));

    }
    @GetMapping
    public ResponseEntity<List<Delito>> index(){
        return ResponseEntity.status(HttpStatus.OK).body(delitoService.consultarDelitos());
    }

}
