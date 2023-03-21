package com.expernet.vkf.resto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.expernet.vkf.resto.model.Emplacement;

@Repository
public interface EmplacementRepository extends CrudRepository<Emplacement, Long>{
    
}
