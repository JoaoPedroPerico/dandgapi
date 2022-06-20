package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.DefinicaoDTO;
import com.dangd.dandg.domain.dto.RegraDTO;
import com.dangd.dandg.domain.services.DefinicaoService;
import com.dangd.dandg.domain.services.RegraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/definicoes")
public class DefinicoesController {
    @Autowired
    private DefinicaoService service = new DefinicaoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getDefinicoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        DefinicaoDTO definicaoDTO = service.getDefinicaoById(id);
        return ResponseEntity.ok(definicaoDTO);
    }
}
