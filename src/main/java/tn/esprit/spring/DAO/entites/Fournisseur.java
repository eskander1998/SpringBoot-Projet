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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private Long idFournisseur; // Clé primaire
	private String codeFournisseur;
	private String libelleFournisseur;
	public Fournisseur(Long idFournisseur, String codeFournisseur, String libelleFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.codeFournisseur = codeFournisseur;
		this.libelleFournisseur = libelleFournisseur;
	}
	public Fournisseur() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeFournisseur == null) ? 0 : codeFournisseur.hashCode());
		result = prime * result + ((idFournisseur == null) ? 0 : idFournisseur.hashCode());
		result = prime * result + ((libelleFournisseur == null) ? 0 : libelleFournisseur.hashCode());
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
		Fournisseur other = (Fournisseur) obj;
		if (codeFournisseur == null) {
			if (other.codeFournisseur != null)
				return false;
		} else if (!codeFournisseur.equals(other.codeFournisseur))
			return false;
		if (idFournisseur == null) {
			if (other.idFournisseur != null)
				return false;
		} else if (!idFournisseur.equals(other.idFournisseur))
			return false;
		if (libelleFournisseur == null) {
			if (other.libelleFournisseur != null)
				return false;
		} else if (!libelleFournisseur.equals(other.libelleFournisseur))
			return false;
		return true;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getLibelleFournisseur() {
		return libelleFournisseur;
	}
	public void setLibelleFournisseur(String libelleFournisseur) {
		this.libelleFournisseur = libelleFournisseur;
	}
	
	
	
}
