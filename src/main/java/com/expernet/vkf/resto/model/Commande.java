package com.expernet.vkf.resto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateHeure")
    private LocalDateTime dateHeure;

    @Column(name = "prix")
    private BigDecimal prix;
    
    @ManyToOne
    @JoinColumn(name = "idTable")
    private Table table;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "lesPlatsCommande",
        joinColumns = @JoinColumn(name = "idCommande"),
        inverseJoinColumns = @JoinColumn(name = "idPlat")
    )
    private List<Plat> lesPlats = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "lesMenusCommande",
        joinColumns = @JoinColumn(name = "idCommande"),
        inverseJoinColumns = @JoinColumn(name = "idMenu")
    )
    private List<Menu> lesMenus = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "lesBoissonsCommande",
        joinColumns = @JoinColumn(name = "idCommande"),
        inverseJoinColumns = @JoinColumn(name = "idBoisson")
    )
    private List<Boisson> lesBoissons = new ArrayList<>();

    public Commande(Long id, LocalDateTime dateHeure, BigDecimal prix, Table table, List<Plat> lesPlats,
            List<Menu> lesMenus, List<Boisson> lesBoissons) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.prix = prix;
        this.table = table;
        this.lesPlats = lesPlats;
        this.lesMenus = lesMenus;
        this.lesBoissons = lesBoissons;
    }

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Plat> getLesPlats() {
        return lesPlats;
    }

    public void setLesPlats(List<Plat> lesPlats) {
        this.lesPlats = lesPlats;
    }

    public List<Menu> getLesMenus() {
        return lesMenus;
    }

    public void setLesMenus(List<Menu> lesMenus) {
        this.lesMenus = lesMenus;
    }

    public List<Boisson> getLesBoissons() {
        return lesBoissons;
    }

    public void setLesBoissons(List<Boisson> lesBoissons) {
        this.lesBoissons = lesBoissons;
    }

    @Override
    public String toString() {
        return "Commande [id=" + id + ", dateHeure=" + dateHeure + ", prix=" + prix + ", table=" + table + ", lesPlats="
                + lesPlats + ", lesMenus=" + lesMenus + ", lesBoissons=" + lesBoissons + "]";
    }
    
}
