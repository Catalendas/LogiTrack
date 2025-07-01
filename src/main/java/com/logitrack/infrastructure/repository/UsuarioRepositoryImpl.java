package com.logitrack.infrastructure.repository;

import com.logitrack.domain.model.Usuario;
import com.logitrack.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Usuario> todos() {
        TypedQuery<Usuario> usuarios = manager.createNamedQuery("from Usuario", Usuario.class);
        return usuarios.getResultList();
    }

    @Override
    public Usuario porId(Long id) {
        return manager.find(Usuario.class, id);
    }

    @Override
    public Usuario porEmail(String email) {
        return manager.find(Usuario.class, email);
    }

    @Transactional
    @Override
    public Usuario adicionar(Usuario usuario) {
        return manager.merge(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        usuario = this.porId(usuario.getId());
        manager.remove(usuario);
    }
}
