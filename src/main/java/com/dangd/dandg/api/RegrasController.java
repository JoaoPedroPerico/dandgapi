package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.RegraDTO;
import com.dangd.dandg.domain.services.RegraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/regras")
public class RegrasController {
    @Autowired
    private RegraService service = new RegraService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getRegras());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        RegraDTO regraDTO = service.getRegraById(id);
        return ResponseEntity.ok(regraDTO);
    }
}
