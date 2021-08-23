package br.com.garde.service;

import java.util.List;

import br.com.garde.model.Garde;

public interface GardeService {

    List<Garde> findAll();

    Garde findbyIdentifier(final String identifier);

    Garde create(Garde garde);

    void delete(String identifier);

    Garde update(Garde garde);

}
