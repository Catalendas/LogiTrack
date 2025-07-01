package com.logitrack.domain.repository;

import com.logitrack.domain.model.Address;

import java.util.List;

public interface AddressRepository {

    List<Address> todos();

    Address porId(Long id);

    Address adicionar(Address address);

    void remover(Address address);

}
