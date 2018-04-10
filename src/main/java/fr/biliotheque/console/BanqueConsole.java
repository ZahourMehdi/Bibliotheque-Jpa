package fr.biliotheque.console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.banque.model.*;
public class BanqueConsole {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(BibliothequeConsole.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
	
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		
		List<Client> listClient = new ArrayList<>();
		List<Client> listClient1 = new ArrayList<>();
		List<Operation> listOperation = new ArrayList<>();
		List<Compte> listCompte = new ArrayList<>();
		
		Adresse a = new Adresse("Rue de la biere", 76610, "Rennes");
		Adresse a1 = new Adresse("11 impasse des martinets", 76610, "Le Havre");
		
		Banque b = new Banque("LCL",listClient);
		Banque b1 = new Banque("BMP",listClient);

		
		
		Client c = new Client("Cyril","Jean",LocalDate.now(),listCompte,b,a);
		Client c1 = new Client("Zahour","Mehdi",LocalDate.of(1995, 03, 25) , listCompte, b1, a1);
		

		Compte livretA = new LivretA("199",50000.0,listClient,listOperation); 
		Compte assuranceVie = new AssuranceVie("3",50000.0,LocalDate.of(3000, 12, 31),listClient,listOperation); 


		Operation ope = new Virement(LocalDate.now(), 55555.0, "Salaire Mars", livretA, "Mehdi");
		Operation ope1 = new Virement(LocalDate.now(), 885.0, "Pole emploi", livretA, "Cyril");
		
		listOperation.add(ope);
		listOperation.add(ope1);
		
		listCompte.add(livretA);
		listCompte.add(assuranceVie);
		
		listClient1.add(c1);
		listClient.add(c);
		
		em.persist(livretA);
		em.persist(assuranceVie);
		em.persist(ope);
		em.persist(ope1);
		em.persist(b);
		em.persist(b1);
		em.persist(c1);
		em.persist(c);
		
		et.commit();
		em.close();
		
		
		em = entityManagerFactory.createEntityManager();
		
		//Réaliser une requête qui recherche tous les comptes d’une personne donnée. Tester cette requête.
		LOG.info("--Réaliser une requête qui recherche tous les comptes d’une personne donnée--");
		Query q = em.createQuery("SELECT comp FROM Compte comp JOIN comp.client c WHERE c.nom=:nom ");
		q.setParameter("nom", "Zahour");
		List<Compte> clientAff = (List<Compte>) q.getResultList();
		clientAff.stream().forEach(co -> LOG.info(co.getNumero()));

		
		//Réaliser une requête qui recherche tous les comptes pour une banque donnée. Tester cette requête.
		LOG.info("--Réaliser une requête qui recherche tous les comptes pour une banque donnée.--");
		q = em.createQuery("SELECT DISTINCT(c.numero) FROM Banque b JOIN b.client cl JOIN cl.compte c WHERE b.nom=:nom");
		q.setParameter("nom", "LCL");
		q.getResultList().stream().forEach(com -> LOG.info((String) com));
		
		//Réaliser une requête qui recherche tous les comptes ayant une opération de plus de 1000€.
		
		LOG.info("--Réaliser une requête qui recherche tous les comptes ayant une opération de plus de 1000€.--");
		q= em.createQuery("SELECT c FROM Compte c JOIN c.operation ope WHERE ope.montant > 1000");
		q.getResultList().stream().forEach(compt -> LOG.info(((Compte) compt).getNumero()));
		
		//Réaliser une requête qui recherche tous les comptes qui ont au moins une opération.
		LOG.info("--Réaliser une requête qui recherche tous les comptes qui ont au moins une opération.--");
		q = em.createQuery("SELECT c FROM Compte c WHERE c.operation IS NOT EMPTY");
		q.getResultList().stream().forEach(compt -> LOG.info(((Compte) compt).getNumero()));
		
		q = em.createQuery("SELECT c FROM Client c");
		q.getResultList();
		
		//Met en cache les clients
		Cache cache = entityManagerFactory.getCache();
		boolean isInCache = cache.contains(Client.class, 1);
		if (isInCache) {
			LOG.info("Je suis dedans !");
		}
		
		em.close();
		entityManagerFactory.close();

	}
}
