package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.CondicaoDTO;
import com.dangd.dandg.domain.services.CondicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/condicoes")
public class CondicoesController {
    @Autowired
    private CondicaoService service = new CondicaoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getCondicoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        CondicaoDTO condicaoDTO = service.getCondicaoById(id);
        return ResponseEntity.ok(condicaoDTO);
    }
}
