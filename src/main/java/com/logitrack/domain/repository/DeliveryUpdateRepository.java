package com.logitrack.domain.repository;

import com.logitrack.domain.model.DeliveryUpdate;

import java.util.List;

public interface DeliveryUpdateRepository {

    List<DeliveryUpdate> todos();

    DeliveryUpdate porId(Long id);

    DeliveryUpdate adicionar(DeliveryUpdate deliveryUpdate);

    void remover(DeliveryUpdate deliveryUpdate);

}
