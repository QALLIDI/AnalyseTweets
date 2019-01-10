package com.json.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.json.model.Entreprise;

public interface IEntreprise extends JpaRepository<Entreprise, Long> {

}
