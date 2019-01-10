package com.json.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.json.model.Commentaire;

public interface IComment extends JpaRepository<Commentaire, Long> {

}
