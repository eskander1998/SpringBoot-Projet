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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DetailProduit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit; // Clé primaire
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit CategorieProduit;
	
	
	@OneToOne(mappedBy="DetailProduit")
	private Produit Produit;
	
	public DetailProduit(Long idDetailProduit, Date dateCreation, Date dateDerniereModification,
			tn.esprit.spring.DAO.entites.CategorieProduit categorieProduit) {
		super();
		this.idDetailProduit = idDetailProduit;
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		CategorieProduit = categorieProduit;
	}

	public DetailProduit() {
		super();
	}

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public CategorieProduit getCategorieProduit() {
		return CategorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		CategorieProduit = categorieProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CategorieProduit == null) ? 0 : CategorieProduit.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((dateDerniereModification == null) ? 0 : dateDerniereModification.hashCode());
		result = prime * result + ((idDetailProduit == null) ? 0 : idDetailProduit.hashCode());
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
		DetailProduit other = (DetailProduit) obj;
		if (CategorieProduit != other.CategorieProduit)
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (dateDerniereModification == null) {
			if (other.dateDerniereModification != null)
				return false;
		} else if (!dateDerniereModification.equals(other.dateDerniereModification))
			return false;
		if (idDetailProduit == null) {
			if (other.idDetailProduit != null)
				return false;
		} else if (!idDetailProduit.equals(other.idDetailProduit))
			return false;
		return true;
	}



}
