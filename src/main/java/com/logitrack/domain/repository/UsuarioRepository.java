package com.logitrack.domain.repository;

import com.logitrack.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepository {

    List<Usuario> todos();

    Usuario porId(Long id);

    Usuario porEmail(String email);

    Usuario adicionar(Usuario usuario);

    void remover(Usuario usuario);

}
