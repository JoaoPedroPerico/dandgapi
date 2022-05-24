package com.dangd.dandg.api;

import com.dangd.dandg.domain.classes.Criatura;
import com.dangd.dandg.domain.services.CriaturaService;
import com.dangd.dandg.domain.dto.CriaturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/criaturas")
public class CriaturasController {
    @Autowired
    private CriaturaService service = new CriaturaService();

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getCriaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        CriaturaDTO criatura = service.getCriaturaById(id);
        return ResponseEntity.ok(criatura);
    }

    @GetMapping("/tipo/{tipoCriatura}")
    public ResponseEntity getByTipoCriatura(@PathVariable("tipoCriatura") String tipoCriatura) {
        List<CriaturaDTO> criaturas = service.getCriaturasByTipoCriatura(tipoCriatura);

        return criaturas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(criaturas);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Criatura criatura) {
        CriaturaDTO temp = service.create(criatura);
        URI location = getUri(criatura.getIdCriatura());
        return ResponseEntity.created(location).build();
    }

    private URI getUri(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody Criatura criatura){
        CriaturaDTO temp = service.update(criatura, id);
        return temp != null ? ResponseEntity.ok(temp) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
