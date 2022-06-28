package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.DefinicaoRegraDTO;
import com.dangd.dandg.domain.services.DefinicaoRegraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/definicoesERegras")
public class DefinicoesERegrasController {
    @Autowired
    private DefinicaoRegraService service = new DefinicaoRegraService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getDefinicoesERegras());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        DefinicaoRegraDTO definicaoRegraDTO = service.getDefinicaoRegraById(id);
        return ResponseEntity.ok(definicaoRegraDTO);
    }
}
