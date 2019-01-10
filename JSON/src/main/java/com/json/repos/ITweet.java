package com.json.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.json.model.Produit;
import com.json.model.Tweet;

public interface ITweet extends JpaRepository<Tweet, Long> {
	Optional<Tweet> findTopByProductOrderByDislikesDesc(Produit p);
}
