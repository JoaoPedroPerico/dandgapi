package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.IdiomaDTO;
import com.dangd.dandg.domain.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/idiomas")
public class IdiomasController {
    @Autowired
    private IdiomaService service = new IdiomaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getIdiomas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        Optional<IdiomaDTO> idioma = service.getIdiomaById(id);

        return idioma.isPresent() ?
                ResponseEntity.ok(idioma.get()) :
                ResponseEntity.notFound().build();
    }
}
