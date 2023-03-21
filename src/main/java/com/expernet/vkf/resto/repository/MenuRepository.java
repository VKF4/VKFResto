package com.expernet.vkf.resto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.expernet.vkf.resto.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>{
    
}
