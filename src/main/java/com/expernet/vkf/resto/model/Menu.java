package com.expernet.vkf.resto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private BigDecimal prix;

    @Column(name = "actif")
    private Boolean actif;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "lesPlatsMenu",
        joinColumns = @JoinColumn(name = "idMenu"),
        inverseJoinColumns = @JoinColumn(name = "idPlat")
    )
    private List<Plat> lesPlatsMenu = new ArrayList<>();

    @ManyToMany(mappedBy = "lesMenusCommande")
    private List<Commande> lesCommandes = new ArrayList<>();

    public Menu(Long id, String nom, BigDecimal prix, Boolean actif, List<Plat> lesPlats, List<Commande> lesCommandes) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.actif = actif;
        this.lesPlatsMenu = lesPlats;
        this.lesCommandes = lesCommandes;
    }

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    
    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public List<Plat> getLesPlats() {
        return lesPlatsMenu;
    }

    public void setLesPlats(List<Plat> lesPlats) {
        this.lesPlatsMenu = lesPlats;
    }

    public List<Plat> addUnPlat(Plat plat){
        this.lesPlatsMenu.add(plat);
        return this.lesPlatsMenu;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public List<Plat> getLesPlatsMenu() {
        return lesPlatsMenu;
    }

    public void setLesPlatsMenu(List<Plat> lesPlatsMenu) {
        this.lesPlatsMenu = lesPlatsMenu;
    }  

    @Override
    public String toString() {
        return "Menu [id=" + id + ", nom=" + nom + ", prix=" + prix + ", actif=" + actif + ", lesPlats=" 
                + lesPlatsMenu + ", lesCommandes=" + lesCommandes + "]";
    }      
}
