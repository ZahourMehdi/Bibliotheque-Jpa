package fr.banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Adresse.
 * @author Zahour Mehdi
 */
@Embeddable
public class Adresse {
	
	
	/** The rue. */
	@Column(name="rue", length=50, nullable=false)
	private String rue;
	
	/** The code postal. */
	@Column(name="codePostal", nullable=false)
	private int codePostal;
	
	/** The ville. */
	@Column(name="ville", length=50, nullable=false)
	private String ville;
	
	public Adresse(){}

	
	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(String rue, int codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
