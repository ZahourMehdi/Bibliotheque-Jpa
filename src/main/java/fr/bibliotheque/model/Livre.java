package fr.bibliotheque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc

/**
 * The Class Livre.
 *
 * @author Zahour Mehdi
 */

@Entity
@Table(name = "livre")
public class Livre {

	/** The id. */
	@Id
	@Column(name="ID")
	private int id;

	/** The titre. */
	@Column(name = "titre", length = 255, nullable = false)
	private String titre;

	@Column(name = "auteur", length = 50, nullable = false)
	/** The auteur. */
	private String auteur;

	@ManyToMany
	@JoinTable(name = "COMPO",
			joinColumns = @JoinColumn(name = "ID_LIVRE", referencedColumnName ="ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
	private List<Emprunt> emprunt;

	/**
	 * Instantiates a new livre.
	 */
	public Livre() {
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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the titre.
	 *
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Sets the titre.
	 *
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Sets the auteur.
	 *
	 * @param auteur
	 *            the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
