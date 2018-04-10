package fr.banque.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Compte.
 * @author Zahour Mehdi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The numero. */
	@Column(name="numero", length=50, nullable=false)
	private String numero;
	
	/** The solde. */
	@Column(name="solde", nullable=false)
	private double solde;
	
	/** The client. */
	@ManyToMany
	@JoinTable(name="CLI_COMP",
				joinColumns= @JoinColumn(name="ID_COMP", referencedColumnName="id"),
				inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="id"))
	private List<Client> client;
	
	/** The compte. */
	@OneToMany(mappedBy="compte")
	private List<Operation> operation;
	
	public Compte(){}
	
	

	/**
	 * @param numero
	 * @param solde
	 * @param client
	 * @param operation
	 */
	public Compte(String numero, double solde, List<Client> client, List<Operation> operation) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.client = client;
		this.operation = operation;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
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

	/**
	 * @return the operation
	 */
	public List<Operation> getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	/**
	 * @return the operation
	 */

	
	
}
