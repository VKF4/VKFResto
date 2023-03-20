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

    @ManyToOne
    @JoinColumn(name = "idTypePlat")
    private TypePlat typePlat;

    @ManyToMany(mappedBy = "lesPlats")
    private List<Menu> lesMenus = new ArrayList<>();

    public Plat(Long id, String nom, BigDecimal prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
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

    public TypePlat getTypePlat() {
        return typePlat;
    }

    public void setTypePlat(TypePlat typePlat) {
        this.typePlat = typePlat;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    
    public List<Menu> getLesMenus() {
        return lesMenus;
    }

    public void setLesMenus(List<Menu> lesMenus) {
        this.lesMenus = lesMenus;
    } 

    @Override
    public String toString() {
        return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", typePlat=" + typePlat + "]";
    }
}
