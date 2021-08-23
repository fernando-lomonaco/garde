package br.com.garde.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.garde.model.Garde;
import br.com.garde.service.GardeService;

@RestController
@RequestMapping("/registers")
public class GardeController {

    @Resource
    GardeService gardeService;

    @GetMapping
    public List<Garde> findAll() {
        return gardeService.findAll();
    }

    @GetMapping("/{identifier}")
    public Garde findByIdentifier(@PathVariable("identifier") final String identifier) {
        return gardeService.findbyIdentifier(identifier);
    }

    @PostMapping
    public Garde create(@RequestBody final Garde garde) {
        return gardeService.create(garde);
    }

    @PutMapping
    public Garde update(@RequestBody final Garde garde) {
        return gardeService.update(garde);
    }

    @DeleteMapping("/{identifier}")
    public void delete(@PathVariable("identifier") final String identifier) {
        gardeService.delete(identifier);
    }

}