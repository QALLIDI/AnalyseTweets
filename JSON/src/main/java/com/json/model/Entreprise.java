package com.json.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String entreprise;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
	private List<Produit> products = new ArrayList<>();

	public Entreprise() {
		super();
	}

	public Entreprise(String nom) {
		super();
		this.entreprise = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String nom) {
		this.entreprise = nom;
	}

	public List<Produit> getProducts() {
		return products;
	}

	public void setProducts(List<Produit> produits) {
		this.products = produits;
	}
}
