package com.expernet.vkf.resto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.EmplacementRepository;
import com.expernet.vkf.resto.model.Emplacement;

@RestController
public class EmplacementController {
    @Autowired
    private EmplacementRepository emplacementRepository;

    @PostMapping("emplacement/new")
    public Emplacement postEmplacement(@RequestBody Emplacement emplacement) {
        emplacementRepository.save(emplacement);
        return emplacement;
    }

    @GetMapping("/emplacement")
    public Iterable<Emplacement> getEmplacement() {
        Iterable<Emplacement> emplacements = emplacementRepository.findAll();
        return emplacements;
    }
    
    @PutMapping("/emplacement/edit/{id}")
    public Emplacement putEmplacement(@PathVariable(value = "id") Long emplacement_id, @RequestBody Emplacement emplacementDetails) {
        Emplacement emplacement = emplacementRepository.findById(emplacement_id).get();   
        emplacement.setNumero(emplacementDetails.getNumero());
        emplacement.setNbPlaces(emplacementDetails.getNbPlaces());
        emplacementRepository.save(emplacement);
        return emplacement;        
    }

    @DeleteMapping("/emplacement/delete/{id}")
    public void deleteEmplacement(@PathVariable(value = "id") Long emplacement_id) {
        emplacementRepository.deleteById(emplacement_id);        
    }
}
