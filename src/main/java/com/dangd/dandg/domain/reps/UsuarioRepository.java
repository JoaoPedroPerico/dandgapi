package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNomeUsuario(String nomeUsuario);
}
