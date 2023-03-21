package com.expernet.vkf.resto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.PlatRepository;
import com.expernet.vkf.resto.model.Plat;

@RestController
public class PlatController {
    @Autowired
    private PlatRepository platRepository;

    @PostMapping("plat/new")
    public Plat postPlat(@RequestBody Plat plat) {
        platRepository.save(plat);
        return plat;
    }

    @GetMapping("/plat")
    public Iterable<Plat> getPlat() {
        Iterable<Plat> plats = platRepository.findAll();
        return plats;
    }
    
    @PutMapping("/plat/edit/{id}")
    public Plat putPlat(@PathVariable(value = "id") Long plat_id, @RequestBody Plat platDetails) {
        Plat plat = platRepository.findById(plat_id).get();   
        plat.setNom(platDetails.getNom());
        plat.setPrix(platDetails.getPrix());
        platRepository.save(plat);
        return plat;        
    }

    @DeleteMapping("/plat/delete/{id}")
    public void deletePlat(@PathVariable(value = "id") Long plat_id) {
        platRepository.deleteById(plat_id);        
    }
}
