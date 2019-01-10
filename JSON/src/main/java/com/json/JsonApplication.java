package com.json;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.json.controller")
public class JsonApplication implements CommandLineRunner {
	/*@Autowired
	private IProduit Ip;
	@Autowired
	private ITweet It;
	@Autowired
	private IEntreprise Ie;
	@Autowired
	private IComment Ic;*/
	public static void main(String[] args) {
		SpringApplication.run(JsonApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*Entreprise e1 = new Entreprise("Apple");
		Entreprise e2 = new Entreprise("Samsung");
		Entreprise e3 = new Entreprise("Nokia");
		List<Entreprise> entreprises = Arrays.asList(e1,e2,e3);
		Ie.saveAll(entreprises);
		
		Optional<Entreprise> ope1 = Ie.findById(1L);
		Produit p1 = new Produit("Iphone X",ope1.get());
		Produit p2 = new Produit("Iphone 6S",ope1.get());
		Produit p3 = new Produit("Iphone 5S",ope1.get());
		Produit p4 = new Produit("Iphone 6S Plus",ope1.get());
		Optional<Entreprise> ope2 = Ie.findById(2L);
		Produit p5 = new Produit("Samsung GALAXY 6S",ope2.get());
		Produit p6 = new Produit("Samsung NOTE",ope2.get());
		Produit p7 = new Produit("Samsung J7",ope2.get());
		Optional<Entreprise> ope3 = Ie.findById(3L);
		Produit p8 = new Produit("Nokia EXPERIA Z",ope3.get());
		Produit p9 = new Produit("Nokia 8",ope3.get());
		List<Produit> produits = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
		Ip.saveAll(produits);
		Optional<Produit> opp1 = Ip.findById(1L);
		Optional<Produit> opp2 = Ip.findById(2L);
		Optional<Produit> opp3 = Ip.findById(3L);
		Optional<Produit> opp4 = Ip.findById(4L);
		Optional<Produit> opp5 = Ip.findById(5L);
		Optional<Produit> opp6 = Ip.findById(6L);
		Optional<Produit> opp7 = Ip.findById(7L);
		Optional<Produit> opp8 = Ip.findById(8L);
		Optional<Produit> opp9 = Ip.findById(9L);
		
		for(int i = 1 ; i <= 12 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("Apple Company");
			t.setLikes(l.nextInt(700));
			t.setDislikes(d.nextInt(900));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp1.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i <= 15 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("Apple Company");
			t.setLikes(l.nextInt(9999));
			t.setDislikes(d.nextInt(9999));
			t.setCreated_at(LocalDate.now().minusWeeks(Integer.toUnsignedLong(i)));
			t.setProduct(opp2.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i <= 10 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("Apple Company");
			t.setLikes(l.nextInt(8000));
			t.setDislikes(d.nextInt(8000));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp3.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i <= 11 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("Apple Company");
			t.setLikes(l.nextInt(800));
			t.setDislikes(d.nextInt(800));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp4.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i < 14 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("SAMSUNG Company");
			t.setLikes(l.nextInt(800));
			t.setDislikes(d.nextInt(500));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp5.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i < 12 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("SAMSUNG Company");
			t.setLikes(l.nextInt(300));
			t.setDislikes(d.nextInt(800));
			t.setCreated_at(LocalDate.now().minusWeeks(Integer.toUnsignedLong(i)));
			t.setProduct(opp6.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i <= 14 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("SAMSUNG Company");
			t.setLikes(l.nextInt(800));
			t.setDislikes(d.nextInt(800));
			t.setCreated_at(LocalDate.now().minusWeeks(Integer.toUnsignedLong(i)));
			t.setProduct(opp7.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i < 11 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("NOKIA Company");
			t.setLikes(l.nextInt(400));
			t.setDislikes(d.nextInt(800));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp8.get());
			It.saveAndFlush(t);
		}
		for(int i = 1 ; i <= 9 ; i++) {
			Tweet t = new Tweet();
			Random l = new Random();
			Random d = new Random();
			t.setTitle("Tweet # "+i);
			t.setContent("NOKIA Company");
			t.setLikes(l.nextInt(500));
			t.setDislikes(d.nextInt(800));
			t.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(i)));
			t.setProduct(opp9.get());
			It.saveAndFlush(t);
		}
		
		List<Tweet> tweets = It.findAll();
		for(Tweet t : tweets) {
			for(int j = 1 ; j <= 10 ; j++) {
				Commentaire c = new Commentaire("Commentaire # "+j , t);
				c.setCreated_at(LocalDate.now().minusDays(Integer.toUnsignedLong(j)));
				Ic.save(c);
			}
		}*/
	}
}
