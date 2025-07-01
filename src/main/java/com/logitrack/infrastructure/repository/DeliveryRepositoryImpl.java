package com.logitrack.infrastructure.repository;

import com.logitrack.domain.model.Delivery;
import com.logitrack.domain.repository.DeliveryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Delivery> todos() {
        TypedQuery<Delivery> deliveries = manager.createQuery("from Delivery", Delivery.class);
        return deliveries.getResultList();
    }

    @Override
    public Delivery porId(Long id) {
        return manager.find(Delivery.class, id);
    }

    @Transactional
    @Override
    public Delivery adicionar(Delivery delivery) {
        return manager.merge(delivery);
    }

    @Transactional
    @Override
    public void remover(Delivery delivery) {
        delivery = this.porId(delivery.getId());
        manager.remove(delivery);
    }
}
