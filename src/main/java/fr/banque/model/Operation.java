package fr.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



// TODO: Auto-generated Javadoc
/**
 * The Class Operation.
 * @author Zahour Mehdi
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Operation {
	
	/** The id operation. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The date. */
	@Column(name="date", nullable=false)
	private LocalDate date;
	
	/** The montant. */
	@Column(name="montant", nullable=false)
	private double montant;
	
	/** The motif. */
	@Column(name="motif", length=50, nullable=false)
	private String motif;
		
	/** The operation. */
	@ManyToOne
	@JoinColumn(name="ID_COMP")
	private Compte compte;
	/**
	 * Instantiates a new operation.
	 */
	public Operation(){}

	
	/**
	 * @param date
	 * @param montant
	 * @param motif
	 * @param compte
	 */
	public Operation(LocalDate date, double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}


	/**
	 * Gets the id operation.
	 *
	 * @return the id_operation
	 */
	public int getId_operation() {
		return id;
	}

	/**
	 * Sets the id operation.
	 *
	 * @param id_operation the id_operation to set
	 */
	public void setId_operation(int id_operation) {
		this.id = id_operation;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 *
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Gets the motif.
	 *
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * Sets the motif.
	 *
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
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
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Gets the compte.
	 *
	 * @return the compte
	 */

	
	
	
}
