package tn.esprit.spring.DAO.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DetailFacture implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture; // Clé primaire
	
	private Integer qte; 
	private float prixTotal;
	private Integer pourcentageRemise; 
	private Integer montantRemise;
	
	@ManyToOne
	Facture factures;
	
	@ManyToOne
	Produit Produit;
	
	public DetailFacture() {
		super();
	}

	public DetailFacture(Long idDetailFacture, Integer qte, float prixTotal, Integer pourcentageRemise,
			Integer montantRemise) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}

	public Long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Integer getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(Integer pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public Integer getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(Integer montantRemise) {
		this.montantRemise = montantRemise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetailFacture == null) ? 0 : idDetailFacture.hashCode());
		result = prime * result + ((montantRemise == null) ? 0 : montantRemise.hashCode());
		result = prime * result + ((pourcentageRemise == null) ? 0 : pourcentageRemise.hashCode());
		result = prime * result + Float.floatToIntBits(prixTotal);
		result = prime * result + ((qte == null) ? 0 : qte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailFacture other = (DetailFacture) obj;
		if (idDetailFacture == null) {
			if (other.idDetailFacture != null)
				return false;
		} else if (!idDetailFacture.equals(other.idDetailFacture))
			return false;
		if (montantRemise == null) {
			if (other.montantRemise != null)
				return false;
		} else if (!montantRemise.equals(other.montantRemise))
			return false;
		if (pourcentageRemise == null) {
			if (other.pourcentageRemise != null)
				return false;
		} else if (!pourcentageRemise.equals(other.pourcentageRemise))
			return false;
		if (Float.floatToIntBits(prixTotal) != Float.floatToIntBits(other.prixTotal))
			return false;
		if (qte == null) {
			if (other.qte != null)
				return false;
		} else if (!qte.equals(other.qte))
			return false;
		return true;
	} 

	
	
}
