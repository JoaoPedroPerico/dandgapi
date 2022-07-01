package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.ProficienciaPorNDDTO;
import com.dangd.dandg.domain.services.ProficienciaPorNDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/proficienciasPorND")
public class ProficienciasPorNDController {
    @Autowired
    private ProficienciaPorNDService service = new ProficienciaPorNDService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getProficienciasPorND());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        ProficienciaPorNDDTO proficienciaPorNDDTO = service.getProficienciaPorNDById(id);
        return ResponseEntity.ok(proficienciaPorNDDTO);
    }
}
