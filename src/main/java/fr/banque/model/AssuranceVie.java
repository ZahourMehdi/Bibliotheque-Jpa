package fr.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AssuranceVie.
 */
@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte {

	/** The date fin. */
	@Column(name="dateFin", nullable=false)
	private LocalDate dateFin;
	
	
	/** The taux. */
	@Column(name="taux", nullable=false)
	private double taux;
	
	
	/**
	 * Instantiates a new assurance vie.
	 */
	public AssuranceVie() {}


	/**
	 * @param numero
	 * @param solde
	 * @param client
	 * @param operation
	 */
	public AssuranceVie(String numero, double solde,LocalDate dateFin, List<Client> client, List<Operation> operation) {
		super(numero, solde, client, operation);
		this.dateFin = dateFin;
		// TODO Auto-generated constructor stub
	}


	/**
	 * Gets the date fin.
	 *
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}


	/**
	 * Sets the date fin.
	 *
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	/**
	 * Gets the taux.
	 *
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}


	/**
	 * Sets the taux.
	 *
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
