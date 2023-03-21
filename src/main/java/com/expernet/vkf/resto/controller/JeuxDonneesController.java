package com.expernet.vkf.resto.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.repository.BoissonRepository;
import com.expernet.vkf.resto.repository.EmplacementRepository;
import com.expernet.vkf.resto.repository.MenuRepository;
import com.expernet.vkf.resto.repository.PlatRepository;
import com.expernet.vkf.resto.repository.TypePlatRepository;
import com.expernet.vkf.resto.model.Boisson;
import com.expernet.vkf.resto.model.Emplacement;
import com.expernet.vkf.resto.model.Menu;
import com.expernet.vkf.resto.model.Plat;
import com.expernet.vkf.resto.model.TypePlat;

@RestController
public class JeuxDonneesController {
    @Autowired
    private BoissonRepository boissonRepository;
    @Autowired
    private TypePlatRepository typePlatRepository;
    @Autowired
    private PlatRepository platRepository;
    @Autowired
    private EmplacementRepository emplacementRepository;
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/addBoisson")
    public Iterable<Boisson> addBoisson() {
        // Boisson
        Map<String, BigDecimal> boissons = new HashMap<String, BigDecimal>() {{
            put("Coca-Cola", new BigDecimal(2));
            put("Virgin Mojito", new BigDecimal(5.50));
            put("Eau Gazeuse", new BigDecimal(3));
            put("Eau Minérale", new BigDecimal(1.50));
            put("Jus de mangue frais", new BigDecimal(3.50));
        }};
        for (Map.Entry<String, BigDecimal> boisson : boissons.entrySet()) {
            Boisson boisson1 = new Boisson();
            boisson1.setNom(boisson.getKey());
            boisson1.setPrix(boisson.getValue());
            boissonRepository.save(boisson1);
        }

        Iterable<Boisson> iterableBoissons = boissonRepository.findAll();

        return iterableBoissons;
    }

    @GetMapping("/addTypePlat")
    public Iterable<TypePlat> addTypePlat() {

        //Type de plat 
        String[] typesplat = {"Entrée", "Plat principal", "Plat d'accompagnement", 
            "Dessert", "Collation ou amuse-gueule"
        };

        for (String typeplat : typesplat) {
            TypePlat typeplat1 = new TypePlat();
            typeplat1.setLibelle(typeplat);
            typePlatRepository.save(typeplat1);
        }

        Iterable<TypePlat> iterableTypesPlat = typePlatRepository.findAll();

        return iterableTypesPlat;
    }

    @GetMapping("/addPlat")
    public Iterable<Plat> addPlat() {
        // Plat 
        Map<String, BigDecimal> platsEntree = new HashMap<String, BigDecimal>() {{
            put("Salade César", new BigDecimal(12.50));
            put("Soupe à l'oignon", new BigDecimal(7.50));
            put("Carpaccio de boeuf", new BigDecimal(14.90));
            put("Brochette de crevettes", new BigDecimal(10.50));
            put("Gaspacho andalou", new BigDecimal(6.90));
            put("Terrine de foie gras", new BigDecimal(19.90));
            put("Assiette de charcuterie", new BigDecimal(12.50));
        }};

        Map<String, BigDecimal> platsPrincipal = new HashMap<String, BigDecimal>() {{
            put("Pâtes carbonara", new BigDecimal(12.50));
            put("Hamburger maison", new BigDecimal(16.90));
            put("Couscous royal", new BigDecimal(18.50));
            put("Tartare de saumon", new BigDecimal(15.90));
            put("Magret de canard", new BigDecimal(21.50));
            put("Tournedos Rossini", new BigDecimal(29.90));
            put("Pizza margherita", new BigDecimal(11.50));
            put("Poulet grillé", new BigDecimal(18.00));
            put("Côte de boeuf", new BigDecimal(35.90));
        }};

        Map<String, BigDecimal> platsAccompagnement = new HashMap<String, BigDecimal>() {{
            put("Portion de Riz", new BigDecimal(3.50));
            put("Riz cantonais", new BigDecimal(8.50));
            put("Gratin dauphinois", new BigDecimal(9.90));
            put("Pommes de terre sautées", new BigDecimal(6.90));
            put("Légumes grillés", new BigDecimal(7.50));
        }};

        Map<String, BigDecimal> platsDessert = new HashMap<String, BigDecimal>() {{
            put("Salade de fruits frais", new BigDecimal(6.50));
            put("Crème brûlée", new BigDecimal(8.50));
            put("Tarte Tatin", new BigDecimal(7.90));
            put("Tarte aux pommes", new BigDecimal(8));
        }};

        Map<String, BigDecimal> platsCollation = new HashMap<String, BigDecimal>() {{
            put("Muffins aux pépites de chocolat", new BigDecimal(5.50));
            put("Mini sandwichs au jambon", new BigDecimal(6.50));
            put("Mini quiches", new BigDecimal(7.50));
            put("Crevettes en tempura", new BigDecimal(8.90));
        }};

        for (Map.Entry<String, BigDecimal> platEntree : platsEntree.entrySet()) {
            Plat platEntree1 = new Plat();
            platEntree1.setNom(platEntree.getKey());
            platEntree1.setPrix(platEntree.getValue());
            platEntree1.setTypePlat(typePlatRepository.findById(1L).get());
            platEntree1.setActif(true);
            platRepository.save(platEntree1);
        }

        for (Map.Entry<String, BigDecimal> platPrincipal : platsPrincipal.entrySet()) {
            Plat platPrincipal1 = new Plat();
            platPrincipal1.setNom(platPrincipal.getKey());
            platPrincipal1.setPrix(platPrincipal.getValue());
            platPrincipal1.setTypePlat(typePlatRepository.findById(2L).get());
            platPrincipal1.setActif(true);
            platRepository.save(platPrincipal1);
        }
        
        for (Map.Entry<String, BigDecimal> platAccompagnement : platsAccompagnement.entrySet()) {
            Plat platAccompagnement1 = new Plat();
            platAccompagnement1.setNom(platAccompagnement.getKey());
            platAccompagnement1.setPrix(platAccompagnement.getValue());
            platAccompagnement1.setTypePlat(typePlatRepository.findById(3L).get());
            platAccompagnement1.setActif(true);
            platRepository.save(platAccompagnement1);
        }

        for (Map.Entry<String, BigDecimal> platDessert : platsDessert.entrySet()) {
            Plat platDessert1 = new Plat();
            platDessert1.setNom(platDessert.getKey());
            platDessert1.setPrix(platDessert.getValue());
            platDessert1.setTypePlat(typePlatRepository.findById(4L).get());
            platDessert1.setActif(true);
            platRepository.save(platDessert1);
        }

        for (Map.Entry<String, BigDecimal> platCollation : platsCollation.entrySet()) {
            Plat platCollation1 = new Plat();
            platCollation1.setNom(platCollation.getKey());
            platCollation1.setPrix(platCollation.getValue());
            platCollation1.setTypePlat(typePlatRepository.findById(5L).get());
            platCollation1.setActif(true);
            platRepository.save(platCollation1);
        }

        Iterable<Plat> iterablePlats = platRepository.findAll();

        return iterablePlats;
    }

    @GetMapping("/addEmplacement")
    public Iterable<Emplacement> addEmplacement() {
        // Emplacement 
        Map<Long, Long> emplacements = new HashMap<Long, Long>() {{
            put(1L, 4L);
            put(2L, 2L);
            put(3L, 6L);
            put(4L, 8L);
            put(5L, 2L);
            put(6L, 4L);
            put(7L, 6L);
            put(8L, 2L);
            put(9L, 4L);
            put(10L, 6L);
            put(11L, 8L);
            put(12L, 4L);
            put(13L, 2L);
            put(14L, 6L);
            put(15L, 4L);
        }};

        for (Map.Entry<Long, Long> emplacement : emplacements.entrySet()) {
            Emplacement emplacement1 = new Emplacement();
            emplacement1.setNumero(emplacement.getKey());
            emplacement1.setNbPlaces(emplacement.getValue());
            emplacementRepository.save(emplacement1);
        }

        Iterable<Emplacement> iterableEmplacement = emplacementRepository.findAll();

        return iterableEmplacement;
    }

    @GetMapping("/addMenu")
    public Iterable<Menu> addMenu() {
        // Menu 
        Menu menu1 = new Menu();
        menu1.setNom("Menu du jour");
        menu1.setPrix(new BigDecimal(25.00));
        menu1.setActif(true);
        menu1.addUnPlat(platRepository.findById(2L).get());
        menu1.addUnPlat(platRepository.findById(15L).get());
        menu1.addUnPlat(platRepository.findById(19L).get());
        menu1.addUnPlat(platRepository.findById(25L).get());
        menuRepository.save(menu1);

        Menu menu2 = new Menu();
        menu2.setNom("Menu végétarien");
        menu2.setPrix(new BigDecimal(22.00));
        menu2.setActif(true);
        menu2.addUnPlat(platRepository.findById(1L).get());
        menu2.addUnPlat(platRepository.findById(11L).get());
        menu2.addUnPlat(platRepository.findById(21L).get());
        menu2.addUnPlat(platRepository.findById(22L).get());
        menuRepository.save(menu2);

        Menu menu3 = new Menu();
        menu3.setNom("Menu enfant");
        menu3.setPrix(new BigDecimal(12.00));
        menu3.setActif(true);
        menu3.addUnPlat(platRepository.findById(27L).get());
        menu3.addUnPlat(platRepository.findById(14L).get());
        menu3.addUnPlat(platRepository.findById(19L).get());
        menu3.addUnPlat(platRepository.findById(22L).get());
        menuRepository.save(menu3);

        Menu menu4 = new Menu();
        menu4.setNom("Menu dégustation");
        menu4.setPrix(new BigDecimal(45.00));
        menu4.setActif(true);
        menu4.addUnPlat(platRepository.findById(6L).get());
        menu4.addUnPlat(platRepository.findById(12L).get());
        menu4.addUnPlat(platRepository.findById(19L).get());
        menu4.addUnPlat(platRepository.findById(24L).get());
        menuRepository.save(menu4);

        Menu menu5 = new Menu();
        menu5.setNom("Menu du chef");
        menu5.setPrix(new BigDecimal(55.00));
        menu5.setActif(true);
        menu5.addUnPlat(platRepository.findById(3L).get());
        menu5.addUnPlat(platRepository.findById(13L).get());
        menu5.addUnPlat(platRepository.findById(21L).get());
        menu5.addUnPlat(platRepository.findById(23L).get());
        menuRepository.save(menu5);

        Iterable<Menu> iterableMenu = menuRepository.findAll();

        return iterableMenu;
    }    
}