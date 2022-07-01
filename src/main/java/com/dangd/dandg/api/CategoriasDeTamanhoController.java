package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.CategoriaDeTamanhoDTO;
import com.dangd.dandg.domain.services.CategoriaDeTamanhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categoriasDeTamanho")
public class CategoriasDeTamanhoController {
    @Autowired
    private CategoriaDeTamanhoService service = new CategoriaDeTamanhoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getCategoriasDeTamanho());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        CategoriaDeTamanhoDTO categoriaDeTamanhoDTO = service.getCategoriaDeTamanhoById(id);
        return ResponseEntity.ok(categoriaDeTamanhoDTO);
    }
}
