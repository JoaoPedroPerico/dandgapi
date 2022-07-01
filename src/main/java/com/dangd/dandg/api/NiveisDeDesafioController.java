package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.NivelDeDesafioDTO;
import com.dangd.dandg.domain.services.NivelDeDesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/niveisDeDesafio")
public class NiveisDeDesafioController {
    @Autowired
    private NivelDeDesafioService service = new NivelDeDesafioService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getNiveisDeDesafio());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        NivelDeDesafioDTO nivelDeDesafioDTO = service.getNivelDeDesafioById(id);
        return ResponseEntity.ok(nivelDeDesafioDTO);
    }
}
