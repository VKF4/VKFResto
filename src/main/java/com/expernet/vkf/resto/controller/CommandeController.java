package com.expernet.vkf.resto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.CommandeRepository;
import com.expernet.vkf.resto.model.Commande;

@RestController
public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;

    @PostMapping("commande/new")
    public Commande postCommande(@RequestBody Commande commande) {
        commandeRepository.save(commande);
        return commande;
    }

    @GetMapping("/commande")
    public Iterable<Commande> getCommande() {
        Iterable<Commande> commandes = commandeRepository.findAll();
        return commandes;
    }
    
    @PutMapping("/commande/edit/{id}")
    public Commande putCommande(@PathVariable(value = "id") Long commande_id, @RequestBody Commande commandeDetails) {
        Commande commande = commandeRepository.findById(commande_id).get(); 
        commande.setDateHeure(commandeDetails.getDateHeure());
        commande.setPrix(commandeDetails.getPrix());
        commande.setEmplacement(commandeDetails.getEmplacement());
        commande.setLesBoissons(commandeDetails.getLesBoissons());
        commande.setLesMenus(commandeDetails.getLesMenus());
        commande.setLesPlats(commandeDetails.getLesPlats());
        commandeRepository.save(commande);
        return commande;        
    }

    @DeleteMapping("/commande/delete/{id}")
    public void deleteCommande(@PathVariable(value = "id") Long commande_id) {
        commandeRepository.deleteById(commande_id);        
    }
}
