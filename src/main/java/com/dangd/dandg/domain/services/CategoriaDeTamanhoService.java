package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.CategoriaDeTamanho;
import com.dangd.dandg.domain.dto.CategoriaDeTamanhoDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.CategoriaDeTamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaDeTamanhoService {
    @Autowired
    private CategoriaDeTamanhoRepository rep;

    public List<CategoriaDeTamanhoDTO> getCategoriasDeTamanho() {
        List<CategoriaDeTamanho> categoriasDeTamanho = rep.findAll();
        List<CategoriaDeTamanhoDTO> categoriasDeTamanhoDTO = new ArrayList<>();
        for (CategoriaDeTamanho categoriaDeTamanho : categoriasDeTamanho){
            categoriasDeTamanhoDTO.add(CategoriaDeTamanhoDTO.create(categoriaDeTamanho));
        }
        return categoriasDeTamanhoDTO;
    }

    public CategoriaDeTamanhoDTO getCategoriaDeTamanhoById(Integer id) {
        Optional<CategoriaDeTamanho> categoriaDeTamanho = rep.findById(id);
        return categoriaDeTamanho.map(CategoriaDeTamanhoDTO::create).orElseThrow(()-> new ObjectNotFoundException("Categoria de tamanho não encontrado"));
    }
}
