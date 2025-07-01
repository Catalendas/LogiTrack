package com.logitrack.domain.repository;

import com.logitrack.domain.model.Delivery;

import java.util.List;

public interface DeliveryRepository {

    List<Delivery> todos();

    Delivery porId(Long id);

    Delivery adicionar(Delivery delivery);

    void remover(Delivery delivery);

}
