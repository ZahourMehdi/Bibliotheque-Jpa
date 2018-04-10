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
 * The Class Client.
 * @author Zahour Mehdi
 */
@Entity
@Table(name="client")
public class Client {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The nom. */
	@Column(name="nom", length=50, nullable=false, unique=true)
	private String nom;
	
	/** The prenom. */
	@Column(name="prenom", length=50, nullable=false)
	private String prenom;
	
	/** The date naissance. */
	@Column(name="dateNaissance",nullable=false)
	private LocalDate dateNaissance;

	/** The compte. */
	@ManyToMany
	@JoinTable(name="CLI_COMP",
				joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="id"),
				inverseJoinColumns= @JoinColumn(name="ID_COMP", referencedColumnName="id"))
	private List<Compte> compte;
	
	@ManyToOne
	@JoinColumn(name="ID_BAN")
	private Banque banque;
	
	
	/** The adr. */
	@Embedded
	private Adresse adr;
	
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param compte
	 * @param banque
	 * @param adr
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, List<Compte> compte, Banque banque, Adresse adr) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.compte = compte;
		this.banque = banque;
		this.adr = adr;
	}

	/**
	 * Instantiates a new client.
	 */
	public Client(){}

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

	/**
	 * Gets the date naissance.
	 *
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Sets the date naissance.
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Gets the compte.
	 *
	 * @return the compte
	 */
	public List<Compte> getCompte() {
		return compte;
	}

	/**
	 * Sets the compte.
	 *
	 * @param compte the compte to set
	 */
	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

	/**
	 * Gets the banque.
	 *
	 * @return the banque
	 */

	/**
	 * Gets the adr.
	 *
	 * @return the adr
	 */
	public Adresse getAdr() {
		return adr;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * Sets the adr.
	 *
	 * @param adr the adr to set
	 */
	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
	
	
	
}
