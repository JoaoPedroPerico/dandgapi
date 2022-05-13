package com.dangd.dandg.api;

import com.dangd.dandg.domain.dto.TipoDeDanoDTO;
import com.dangd.dandg.domain.services.TipoDeDanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/tiposDeDano")
public class TiposDeDanoController {
    @Autowired
    private TipoDeDanoService service = new TipoDeDanoService();

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getTiposDeDano());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        Optional<TipoDeDanoDTO> tipoDeDanoDTO = service.getTipoDeDanoById(id);

        return tipoDeDanoDTO.isPresent() ?
                ResponseEntity.ok(tipoDeDanoDTO.get()) :
                ResponseEntity.notFound().build();
    }
}
