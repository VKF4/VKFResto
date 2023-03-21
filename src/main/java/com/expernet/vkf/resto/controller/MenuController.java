package com.expernet.vkf.resto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.MenuRepository;
import com.expernet.vkf.resto.model.Menu;

@RestController
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    @PostMapping("menu/new")
    public Menu postMenu(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return menu;
    }

    @GetMapping("/menu")
    public Iterable<Menu> getMenu() {
        Iterable<Menu> menus = menuRepository.findAll();
        return menus;
    }
    
    @PutMapping("/menu/edit/{id}")
    public Menu putMenu(@PathVariable(value = "id") Long menu_id, @RequestBody Menu menuDetails) {
        Menu menu = menuRepository.findById(menu_id).get();   
        menu.setNom(menuDetails.getNom());
        menu.setPrix(menuDetails.getPrix());
        menu.setLesPlats(menuDetails.getLesPlats());
        menuRepository.save(menu);
        return menu;        
    }

    @DeleteMapping("/menu/delete/{id}")
    public void deleteMenu(@PathVariable(value = "id") Long menu_id) {
        menuRepository.deleteById(menu_id);        
    }
}
