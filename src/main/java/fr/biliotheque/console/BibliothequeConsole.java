package fr.biliotheque.console;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.bibliotheque.model.*;


// TODO: Auto-generated Javadoc
/**
 * The Class BibliothequeConsole.
 * @author Zahour Mehdi
 */
public class BibliothequeConsole {

	
	/** The Constant LOG. */
	private static  final Logger LOG = LoggerFactory.getLogger(BibliothequeConsole.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-Jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("select e from Emprunt e where e.date_debut='2017-11-12'");
		Emprunt emprunt = (Emprunt) query.getSingleResult();
	
		emprunt.getLivre().stream().forEach( l -> LOG.info(l.getTitre()));
		
		LOG.info("\n");
		
		query = em.createQuery("select c from Client c where c.nom='Brigand'");
		Client c = (Client) query.getSingleResult();
		c.getEmprunt().stream().forEach( c1 -> LOG.info(c1.getLivre().get(0).getAuteur()));
		
		em.close();
		entityManagerFactory.close();
		
	}
}
