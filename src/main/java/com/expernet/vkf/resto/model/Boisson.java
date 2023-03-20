package com.expernet.vkf.resto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Boisson")
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private BigDecimal prix;

    @ManyToMany(mappedBy = "lesBoissonsCommande")
    private List<Commande> lesCommandes = new ArrayList<>();

    public Boisson(Long id, String nom, BigDecimal prix, List<Commande> lesCommandes) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.lesCommandes = lesCommandes;
    }

    public Boisson() {
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

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    @Override
    public String toString() {
        return "Boisson [id=" + id + ", nom=" + nom + ", prix=" + prix + ", lesCommandes=" + lesCommandes + "]";
    }
}
