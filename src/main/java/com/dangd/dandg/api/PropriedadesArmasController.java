package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.PropriedadeArmaDTO;
import com.dangd.dandg.domain.services.PropriedadeArmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/propriedadesArmas")
public class PropriedadesArmasController {
    @Autowired
    private PropriedadeArmaService service = new PropriedadeArmaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getPropriedadesArmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        PropriedadeArmaDTO propriedadeArmaDTO = service.getPropriedadeArmaById(id);
        return ResponseEntity.ok(propriedadeArmaDTO);
    }
}
