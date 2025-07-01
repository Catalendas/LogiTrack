package com.logitrack.infrastructure.repository;

import com.logitrack.domain.model.Address;
import com.logitrack.domain.repository.AddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Address> todos() {
        TypedQuery<Address> address = manager.createQuery("from Address", Address.class);
        return address.getResultList();
    }

    @Override
    public Address porId(Long id) {
        return manager.find(Address.class, id);
    }

    @Transactional
    @Override
    public Address adicionar(Address address) {
        return manager.merge(address);
    }

    @Transactional
    @Override
    public void remover(Address address) {
        address = this.porId(address.getId());
        manager.remove(address);
    } 
}
