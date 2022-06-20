package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.TalentoDTO;
import com.dangd.dandg.domain.services.TalentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/talentos")
public class TalentosController {
    @Autowired
    private TalentoService service = new TalentoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTalentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        TalentoDTO talentoDTO = service.getTalentoById(id);
        return ResponseEntity.ok(talentoDTO);
    }
}
