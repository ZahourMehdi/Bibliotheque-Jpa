
package fr.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class LivretA.
 * @author Zahour Mehdi
 */
@Entity
@Table(name="livret_a")
public class LivretA extends Compte {

	/** The taux. */
	@Column(name="taux", nullable=false)
	private double taux;
	
	/**
	 * Instantiates a new livret A.
	 */
	public LivretA() {}

	
	/**
	 * @param numero
	 * @param solde
	 * @param client
	 * @param operation
	 */
	public LivretA(String numero, double solde, List<Client> client, List<Operation> operation) {
		super(numero, solde, client, operation);
		// TODO Auto-generated constructor stub
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
