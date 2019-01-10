package com.json.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.json.model.Produit;

public interface IProduit extends JpaRepository<Produit, Long> {

}
