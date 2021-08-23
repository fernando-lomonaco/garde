package br.com.garde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.garde.model.Garde;

@Repository
public interface GardeRepository extends JpaRepository<Garde, String> {
    
}
