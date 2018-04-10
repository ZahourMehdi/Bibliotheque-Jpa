package fr.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Banque.
 *@author Zahour Mehdi
 */
@Entity
@Table(name="banque")
public class Banque {

	/** The id banque. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The nom. */
	@Column(name="nom", length=50, nullable=false)
	private String nom;
	
	/** The client. */
	/** The banque. */
	@OneToMany(mappedBy="banque")
	private List<Client> client;
	
	public Banque(){}
	
	/**
	 * @param nom
	 * @param client
	 * Constructeur pour creer une banque
	 */
	public Banque(String nom, List<Client> client) {
		this.nom = nom;
		this.client = client;
	}

	/**
	 * @return the id_banque
	 */
	public int getId_banque() {
		return id;
	}

	/**
	 * @param id_banque the id_banque to set
	 */
	public void setId_banque(int id_banque) {
		this.id = id_banque;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the client
	 */
	public List<Client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(List<Client> client) {
		this.client = client;
	}


	
	
}
