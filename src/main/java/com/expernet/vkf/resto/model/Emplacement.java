package com.expernet.vkf.resto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emplacement")
public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "nbPlaces")
    private Long nbPlaces;

    public Emplacement(Long id, Long numero, Long nbPlaces) {
        this.id = id;
        this.numero = numero;
        this.nbPlaces = nbPlaces;
    }

    public Emplacement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Long nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    @Override
    public String toString() {
        return "Emplacement [id=" + id + ", numero=" + numero + ", nbPlaces=" + nbPlaces + "]";
    }    
}
