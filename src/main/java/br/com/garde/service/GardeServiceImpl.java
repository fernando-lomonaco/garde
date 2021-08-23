package br.com.garde.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.garde.exception.EntityNotFoundException;
import br.com.garde.model.Garde;
import br.com.garde.repository.GardeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GardeServiceImpl implements GardeService {

    @Resource
    GardeRepository gardeRepository;

    @Override
    @Cacheable(cacheNames = Garde.CACHE_NAME, key = "#root.method.name")
    public List<Garde> findAll() {
        return gardeRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = Garde.CACHE_NAME, key = "#identifier")
    public Garde findbyIdentifier(final String identifier) {
        return gardeRepository.findById(identifier)
                .orElseThrow(() -> new EntityNotFoundException("Identifier not found: " + identifier));
    }

    @Override
    @CacheEvict(cacheNames = Garde.CACHE_NAME, allEntries = true)
    public Garde create(Garde garde) {
        log.info("Save garde {}", garde);
        return gardeRepository.save(garde);
    }

    @Override
    @CachePut(cacheNames = Garde.CACHE_NAME, key = "#garde.getIdentifier()")
    public Garde update(final Garde garde) {
        if (garde.getIdentifier() == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        return gardeRepository.save(garde);
    }

    @Override
    @CacheEvict(cacheNames = Garde.CACHE_NAME, key = "#identifier")
    public void delete(final String identifier) {
        if (identifier == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }

        gardeRepository.deleteById(identifier);
    }
}
