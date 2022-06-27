package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.PropriedadeArmaDTO;
import com.dangd.dandg.domain.dto.TipoDeArmaDTO;
import com.dangd.dandg.domain.services.PropriedadeArmaService;
import com.dangd.dandg.domain.services.TipoDeArmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tiposDeArmas")
public class TiposDeArmasController {
    @Autowired
    private TipoDeArmaService service = new TipoDeArmaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTiposDeArmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        TipoDeArmaDTO tipoDeArmaDTO = service.getTipoDeArmaById(id);
        return ResponseEntity.ok(tipoDeArmaDTO);
    }
}
