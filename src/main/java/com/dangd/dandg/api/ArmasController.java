package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.ArmaDTO;
import com.dangd.dandg.domain.dto.PericiaDTO;
import com.dangd.dandg.domain.services.ArmaService;
import com.dangd.dandg.domain.services.PericiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/armas")
public class ArmasController {
    @Autowired
    private ArmaService service = new ArmaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getArmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        ArmaDTO arma = service.getArmaById(id);
        return ResponseEntity.ok(arma);
    }

    @GetMapping("/tipoDeArma/{tipoDeArma}")
    public ResponseEntity getByTipoDeArma(@PathVariable("tipoDeArma") Integer tipoDeArma) {
        List<ArmaDTO> armas = service.getArmasByTipoDeArma(tipoDeArma);

        return armas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(armas);
    }
}
