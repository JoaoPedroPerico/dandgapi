package com.dangd.dandg.api;

import com.dangd.dandg.domain.classes.Tendencia;
import com.dangd.dandg.domain.dto.TendenciaDTO;
import com.dangd.dandg.domain.services.TendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/tendencias")
public class TendenciasController {
    @Autowired
    private TendenciaService service = new TendenciaService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTendencias());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        Optional<TendenciaDTO> tendencia = service.getTendenciaById(id);

        return tendencia.isPresent() ?
                ResponseEntity.ok(tendencia.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/abreviacao/{sigla}")
    public ResponseEntity getBySigla(@PathVariable("sigla") String sigla){
        Optional<TendenciaDTO> tendencia = service.getTendenciaBySigla(sigla);

        return tendencia.isPresent() ?
                ResponseEntity.ok(tendencia.get()) :
                ResponseEntity.notFound().build();
    }
}
