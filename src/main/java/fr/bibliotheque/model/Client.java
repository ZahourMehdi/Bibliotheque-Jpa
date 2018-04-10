package fr.bibliotheque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 * @author Zahour Mehdi
 */

@Entity
@Table(name="client")
public class Client {
	
	/** The id. */
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	/** The nom. */
	@Column(name="nom", length=50, nullable=false)
	private String nom;
	
	/** The prenom. */
	@Column(name="prenom", length=50, nullable=false)
	private String prenom;
	
	/** The emprunt. Liste d'emprunt */
	@OneToMany(mappedBy="client")
	private List<Emprunt> emprunt;
	
	
	/**
	 * Instantiates a new client.
	 */
	public Client(){}

	/**
	 * @return the emprunt
	 */
	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
