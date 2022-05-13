package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.AtributoDTO;
import com.dangd.dandg.domain.dto.CriaturaDTO;
import com.dangd.dandg.domain.dto.PericiaDTO;
import com.dangd.dandg.domain.services.AtributoService;
import com.dangd.dandg.domain.services.PericiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pericias")
public class PericiasController {
    @Autowired
    private PericiaService service = new PericiaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getPericias());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        Optional<PericiaDTO> pericia = service.getPericiaById(id);

        return pericia.isPresent() ?
                ResponseEntity.ok(pericia.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/atributo/{atributo}")
    public ResponseEntity getByTipoModificador(@PathVariable("atributo") String atributo) {
        List<PericiaDTO> pericias = service.getPericiasByModificador(atributo);

        return pericias.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pericias);
    }
}
