package com.json.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String content;
	private int likes;
	private int dislikes;
	private LocalDate created_at;
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "tweet")
	private List<Commentaire> comments = new ArrayList<>();
	@JsonIgnore
	@ManyToOne
	private Produit product;
	public Tweet() {
		super();
	}
	public Tweet(String content , Produit produit) {
		super();
		this.content = content;
		this.likes = 0;
		this.dislikes = 0;
		this.created_at = LocalDate.now();
		this.product = produit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public Produit getProduct() {
		return product;
	}
	public void setProduct(Produit produit) {
		this.product = produit;
	}
	public List<Commentaire> getComments() {
		return comments;
	}
	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}
	public int CompareTweetsByDislikes(Tweet t) {
		return this.getDislikes() - t.getDislikes();
	}
}
