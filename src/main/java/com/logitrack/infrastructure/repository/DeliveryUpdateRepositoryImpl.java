package com.logitrack.infrastructure.repository;

import com.logitrack.domain.model.DeliveryUpdate;
import com.logitrack.domain.repository.DeliveryUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DeliveryUpdateRepositoryImpl implements DeliveryUpdateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<DeliveryUpdate> todos() {
        TypedQuery<DeliveryUpdate> deliveriesUpdate = manager.createQuery("from DeliveryUpdate", DeliveryUpdate.class);
        return deliveriesUpdate.getResultList();
    }

    @Override
    public DeliveryUpdate porId(Long id) {
        return manager.find(DeliveryUpdate.class, id);
    }

    @Transactional
    @Override
    public DeliveryUpdate adicionar(DeliveryUpdate deliveryUpdate) {
        return manager.merge(deliveryUpdate);
    }

    @Transactional
    @Override
    public void remover(DeliveryUpdate deliveryUpdate) {
        deliveryUpdate = this.porId(deliveryUpdate.getId());
        manager.remove(deliveryUpdate);
    }
}
