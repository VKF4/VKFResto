package com.expernet.vkf.resto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Plat")
public class Plat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private BigDecimal prix;

    @Column(name = "actif")
    private Boolean actif;

    @ManyToOne
    @JoinColumn(name = "idTypePlat")
    private TypePlat typePlat;

    @ManyToMany(mappedBy = "lesPlatsMenu")
    private List<Menu> lesMenus = new ArrayList<>();

    @ManyToMany(mappedBy = "lesPlatsCommande")
    private List<Commande> lesCommandes = new ArrayList<>();

    public Plat(Long id, String nom, BigDecimal prix, TypePlat typePlat, List<Menu> lesMenus,
            List<Commande> lesCommandes) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.typePlat = typePlat;
        this.lesMenus = lesMenus;
        this.lesCommandes = lesCommandes;
    }

    public Plat() {
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

    public TypePlat getTypePlat() {
        return typePlat;
    }

    public void setTypePlat(TypePlat typePlat) {
        this.typePlat = typePlat;
    }

    public List<Menu> getLesMenus() {
        return lesMenus;
    }

    public void setLesMenus(List<Menu> lesMenus) {
        this.lesMenus = lesMenus;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    @Override
    public String toString() {
        return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", actif=" + actif + ", typePlat=" + typePlat 
                + ", lesMenus=" + lesMenus + ", lesCommandes=" + lesCommandes + "]";
    }   
}
