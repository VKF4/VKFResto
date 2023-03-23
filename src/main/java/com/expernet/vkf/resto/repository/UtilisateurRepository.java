package com.expernet.vkf.resto.repository;

import org.springframework.data.repository.CrudRepository;

import com.expernet.vkf.resto.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {
    
}
