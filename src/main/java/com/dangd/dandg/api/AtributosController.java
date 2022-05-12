package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.AtributoDTO;
import com.dangd.dandg.domain.services.AtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/atributos")
public class AtributosController {
    @Autowired
    private AtributoService service = new AtributoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getAtributos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        Optional<AtributoDTO> idioma = service.getAtributoById(id);

        return idioma.isPresent() ?
                ResponseEntity.ok(idioma.get()) :
                ResponseEntity.notFound().build();
    }
}
