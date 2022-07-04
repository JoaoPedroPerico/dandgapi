package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.AcaoCriaturaDTO;
import com.dangd.dandg.domain.dto.TracoEspecialDTO;
import com.dangd.dandg.domain.services.AcaoCriaturaService;
import com.dangd.dandg.domain.services.TracoEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/acoesCriaturas")
public class AcoesCriaturasController {
    @Autowired
    private AcaoCriaturaService service = new AcaoCriaturaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getAcoesCriaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        AcaoCriaturaDTO acaoCriaturaDTO = service.getAcaoCriaturaById(id);
        return ResponseEntity.ok(acaoCriaturaDTO);
    }
}
