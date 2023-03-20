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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "lesPlats",
        joinColumns = @JoinColumn(name = "idMenu"),
        inverseJoinColumns = @JoinColumn(name = "idPlat")
    )
    private List<Plat> lesPlats = new ArrayList<>();

    public Menu(Long id, String nom, BigDecimal prix, List<Plat> lesPlats) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.lesPlats = lesPlats;
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

    public List<Plat> getLesPlats() {
        return lesPlats;
    }

    public void setLesPlats(List<Plat> lesPlats) {
        this.lesPlats = lesPlats;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", nom=" + nom + ", prix=" + prix + ", lesPlats=" + lesPlats + "]";
    }
}
