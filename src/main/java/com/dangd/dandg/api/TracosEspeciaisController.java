package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.TracoEspecialDTO;
import com.dangd.dandg.domain.services.TracoEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tracosEspeciais")
public class TracosEspeciaisController {
    @Autowired
    private TracoEspecialService service = new TracoEspecialService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTracosEspeciais());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        TracoEspecialDTO tracoEspecialDTO = service.getTracoEspecialById(id);
        return ResponseEntity.ok(tracoEspecialDTO);
    }
}
