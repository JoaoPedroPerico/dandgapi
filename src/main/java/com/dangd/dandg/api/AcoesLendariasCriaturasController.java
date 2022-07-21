package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.AcaoLendariaCriaturaDTO;
import com.dangd.dandg.domain.services.AcaoLendariaCriaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/acoesLendariasCriaturas")
public class AcoesLendariasCriaturasController {
    @Autowired
    private AcaoLendariaCriaturaService service = new AcaoLendariaCriaturaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getAcoesLendariasCriaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        AcaoLendariaCriaturaDTO acaoLendariaCriaturaDTO = service.getAcaoLendariaCriaturaById(id);
        return ResponseEntity.ok(acaoLendariaCriaturaDTO);
    }
}
