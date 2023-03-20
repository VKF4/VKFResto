package com.expernet.vkf.resto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.BoissonRepository;
import com.expernet.vkf.resto.model.Boisson;

@RestController
public class BoissonController {
    @Autowired
    private BoissonRepository boissonRepository;

    @PostMapping("boisson/new")
    public Boisson postBoisson(@RequestBody Boisson boisson) {
        boissonRepository.save(boisson);
        return boisson;
    }

    @GetMapping("/boisson")
    public Iterable<Boisson> getBoisson() {
        Iterable<Boisson> boissons = boissonRepository.findAll();
        return boissons;
    }
    
    @PutMapping("/boisson/edit/{id}")
    public Boisson putBoisson(@PathVariable(value = "id") Long boisson_id, @RequestBody Boisson boissonDetails) {
        Boisson boisson = boissonRepository.findById(boisson_id).get();   
        boisson.setNom(boissonDetails.getNom());
        boisson.setPrix(boissonDetails.getPrix());
        boissonRepository.save(boisson);
        return boisson;        
    }

    @DeleteMapping("/boisson/delete/{id}")
    public void deleteBoisson(@PathVariable(value = "id") Long boisson_id) {
        boissonRepository.deleteById(boisson_id);        
    }
}
