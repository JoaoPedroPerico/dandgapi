package com.dangd.dandg.api.security;

import com.dangd.dandg.domain.classes.Usuario;
import com.dangd.dandg.domain.reps.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return usuario;
    }
}
