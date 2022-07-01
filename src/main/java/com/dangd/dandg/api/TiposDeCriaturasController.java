package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.TipoDeCriaturaDTO;
import com.dangd.dandg.domain.services.TipoDeCriaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tiposDeCriaturas")
public class TiposDeCriaturasController {
    @Autowired
    private TipoDeCriaturaService service = new TipoDeCriaturaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTiposDeCriaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        TipoDeCriaturaDTO tipoDeCriaturaDTO = service.getTipoDeCriaturaById(id);
        return ResponseEntity.ok(tipoDeCriaturaDTO);
    }
}
