package fr.bibliotheque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
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
 * The Class Emprunt.
 * @author Zahour Mehdi
 */
@Entity
@Table(name="emprunt")
public class Emprunt {
	
	
	/** The id. */
	@Id
	@Column(name="ID")
	private int id;
	
	/** The date debut. */
	@Column(name="date_debut", nullable=false)
	private LocalDate date_debut;
	
	/** The date fin. */
	@Column(name="date_fin", nullable=false)
	private LocalDate date_fin;
	
	/** The delai. */
	@Column(name="delai")
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "COMPO",
			joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName ="ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private List<Livre> livre;

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livre
	 */
	public List<Livre> getLivre() {
		return livre;
	}

	/**
	 * @param livre the livre to set
	 */
	public void setLivre(List<Livre> livre) {
		this.livre = livre;
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
	 * @return the date_debut
	 */
	public LocalDate getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public LocalDate getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	
}
