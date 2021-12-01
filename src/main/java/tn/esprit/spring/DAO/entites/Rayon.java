package tn.esprit.spring.DAO.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rayon implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon; // Clé primaire
	private String codeRayon;
	private String libelleRayon;
	
	@OneToMany(mappedBy="rayon")
	private Set<Produit> Produits;
	
	public Rayon(Long idRayon, String codeRayon, String libelleRayon) {
		super();
		this.idRayon = idRayon;
		this.codeRayon = codeRayon;
		this.libelleRayon = libelleRayon;
	}
	public Rayon() {
		super();
	}
	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}
	public String getCodeRayon() {
		return codeRayon;
	}
	public void setCodeRayon(String codeRayon) {
		this.codeRayon = codeRayon;
	}
	public String getLibelleRayon() {
		return libelleRayon;
	}
	public void setLibelleRayon(String libelleRayon) {
		this.libelleRayon = libelleRayon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeRayon == null) ? 0 : codeRayon.hashCode());
		result = prime * result + ((idRayon == null) ? 0 : idRayon.hashCode());
		result = prime * result + ((libelleRayon == null) ? 0 : libelleRayon.hashCode());
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
		Rayon other = (Rayon) obj;
		if (codeRayon == null) {
			if (other.codeRayon != null)
				return false;
		} else if (!codeRayon.equals(other.codeRayon))
			return false;
		if (idRayon == null) {
			if (other.idRayon != null)
				return false;
		} else if (!idRayon.equals(other.idRayon))
			return false;
		if (libelleRayon == null) {
			if (other.libelleRayon != null)
				return false;
		} else if (!libelleRayon.equals(other.libelleRayon))
			return false;
		return true;
	}
	
	
}
