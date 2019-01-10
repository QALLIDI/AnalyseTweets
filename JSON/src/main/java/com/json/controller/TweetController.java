package com.json.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.json.model.Commentaire;
import com.json.model.Entreprise;
import com.json.model.Produit;
import com.json.model.Tweet;
import com.json.repos.IEntreprise;
import com.json.repos.IProduit;
import com.json.repos.ITweet;

@Controller
@RequestMapping(value = "/home")
public class TweetController {
	@Autowired
	private IEntreprise Ie;
	@Autowired
	private IProduit Ip;
	@Autowired
	private ITweet It;
	@GetMapping(value = "/list")
	public List<Entreprise> List() {
		return Ie.findAll();
	}
	@GetMapping(value = "/")
	public String findAll(Model model) {
		List<Entreprise> entreprises = new ArrayList<>();
		List<Produit> produits = new ArrayList<>();
		List<Commentaire> comments = new ArrayList<>();
		entreprises = Ie.findAll();
		int likes = 0;
		int dislikes = 0;
		Optional<Entreprise> e = Ie.findById(1L);
		produits = Ip.findAll().stream().filter(p -> p.getEntreprise().getId().equals(e.get().getId()))
				.collect(Collectors.toList());
		Produit produit = Ip.findAll().stream().filter(p -> p.getEntreprise().getId().equals(e.get().getId()))
				.findFirst().get();
		for (Tweet t : produit.getTweets()) {
			likes += t.getLikes();
		}
		for (Tweet t : produit.getTweets()) {
			dislikes += t.getDislikes();
		}
		Tweet tweet = It.findTopByProductOrderByDislikesDesc(produit).get();
		comments = tweet.getComments().stream().limit(10).collect(Collectors.toList());
		Map<LocalDate, Integer> MapTweets = produit.getTweets().stream().collect(Collectors.groupingBy(
				Tweet::getCreated_at,
				Collectors.collectingAndThen(Collectors.toCollection(() -> new ArrayList<>()), list -> list.size())));
		model.addAttribute("MapTweets", MapTweets);
		model.addAttribute("entreprises", entreprises);
		model.addAttribute("produits", produits);
		model.addAttribute("entreprise", e.get());
		model.addAttribute("produit", produit);
		model.addAttribute("likes", likes);
		model.addAttribute("dislikes", dislikes);
		model.addAttribute("comments", comments);
		model.addAttribute("tweet", tweet);
		model.addAttribute("title", "Tweets Analyzer");
		return "home";
	}

	@GetMapping("/entreprise")
	public String findEntreprise(Model model, @Param("id") Long id) {
		List<Entreprise> entreprises = new ArrayList<>();
		List<Produit> produits = new ArrayList<>();
		List<Commentaire> comments = new ArrayList<>();
		entreprises = Ie.findAll();
		int likes = 0;
		int dislikes = 0;
		Optional<Entreprise> e = Ie.findById(id);
		produits = Ip.findAll().stream().filter(p -> p.getEntreprise().getId().equals(e.get().getId()))
				.collect(Collectors.toList());
		Produit produit = Ip.findAll().stream().filter(p -> p.getEntreprise().getId().equals(e.get().getId()))
				.findFirst().get();
		for (Tweet t : produit.getTweets()) {
			likes += t.getLikes();
		}
		for (Tweet t : produit.getTweets()) {
			dislikes += t.getDislikes();
		}
		Tweet tweet = It.findTopByProductOrderByDislikesDesc(produit).get();
		comments = tweet.getComments().stream().limit(10).collect(Collectors.toList());
		Map<LocalDate, Integer> MapTweets = produit.getTweets().stream().collect(Collectors.groupingBy(
				Tweet::getCreated_at,
				Collectors.collectingAndThen(Collectors.toCollection(() -> new ArrayList<>()), list -> list.size())));
		model.addAttribute("MapTweets", MapTweets);
		model.addAttribute("entreprises", entreprises);
		model.addAttribute("produits", produits);
		model.addAttribute("likes", likes);
		model.addAttribute("entreprise", e.get());
		model.addAttribute("produit", produit);
		model.addAttribute("dislikes", dislikes);
		model.addAttribute("comments", comments);
		model.addAttribute("tweet", tweet);
		model.addAttribute("title", "Tweets Analyzer");
		return "home";
	}

	@GetMapping("/produit")
	public String findProduit(Model model, @Param("id") Long id) {
		List<Entreprise> entreprises = new ArrayList<>();
		List<Produit> produits = new ArrayList<>();
		List<Commentaire> comments = new ArrayList<>();
		entreprises = Ie.findAll();
		int likes = 0;
		int dislikes = 0;
		Produit produit = Ip.findById(id).get();
		Entreprise e = produit.getEntreprise();
		produits = Ip.findAll().stream().filter(p -> p.getEntreprise().getId().equals(e.getId()))
				.collect(Collectors.toList());
		for (Tweet t : produit.getTweets()) {
			likes += t.getLikes();
		}
		for (Tweet t : produit.getTweets()) {
			dislikes += t.getDislikes();
		}
		Tweet tweet = It.findTopByProductOrderByDislikesDesc(produit).get();
		comments = tweet.getComments().stream().limit(10).collect(Collectors.toList());
		Map<LocalDate, Integer> MapTweets = produit.getTweets().stream().collect(Collectors.groupingBy(
				Tweet::getCreated_at,
				Collectors.collectingAndThen(Collectors.toCollection(() -> new ArrayList<>()), list -> list.size())));
		model.addAttribute("MapTweets", MapTweets);
		model.addAttribute("entreprises", entreprises);
		model.addAttribute("produits", produits);
		model.addAttribute("likes", likes);
		model.addAttribute("dislikes", dislikes);
		model.addAttribute("likes", likes);
		model.addAttribute("entreprise", e);
		model.addAttribute("produit", produit);
		model.addAttribute("comments", comments);
		model.addAttribute("tweet", tweet);
		model.addAttribute("title", "Tweets Analyzer");
		return "home";
	}
}
