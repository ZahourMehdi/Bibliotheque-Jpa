package fr.banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Virement.
 * @author Zahour Mehdi
 */
@Entity
public class Virement extends Operation {

	/** The beneficiaire. */
	@Column(name="beneficaire", length=50, nullable=false)
	private String beneficiaire;
	
	/**
	 * Instantiates a new virement.
	 */
	public Virement() {}
	
	/**
	 * @param date
	 * @param montant
	 * @param motif
	 * @param compte
	 */
	public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiare) {
		super(date, montant, motif, compte);
		this.beneficiaire=beneficiare;
		// TODO Auto-generated constructor stub
	}



	/**
	 * Gets the beneficiaire.
	 *
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * Sets the beneficiaire.
	 *
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	

}
