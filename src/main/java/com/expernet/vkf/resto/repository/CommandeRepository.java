package com.expernet.vkf.resto.repository;

import org.springframework.data.repository.CrudRepository;

import com.expernet.vkf.resto.model.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Long> {
    
}
