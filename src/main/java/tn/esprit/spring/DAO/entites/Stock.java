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
public class Stock implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock; // Clé primaire
	private int qteStock;
	private int qteMin;
	private String libelleStock;
	
	@OneToMany(mappedBy="stock")
	private Set<Produit> Produits;
	
	public Stock() {
		super();
	}
	public Stock(Long idStock, int qteStock, int qteMin, String libelleStock) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}
	public Long getIdStock() {
		return idStock;
	}
	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStock == null) ? 0 : idStock.hashCode());
		result = prime * result + ((libelleStock == null) ? 0 : libelleStock.hashCode());
		result = prime * result + qteMin;
		result = prime * result + qteStock;
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
		Stock other = (Stock) obj;
		if (idStock == null) {
			if (other.idStock != null)
				return false;
		} else if (!idStock.equals(other.idStock))
			return false;
		if (libelleStock == null) {
			if (other.libelleStock != null)
				return false;
		} else if (!libelleStock.equals(other.libelleStock))
			return false;
		if (qteMin != other.qteMin)
			return false;
		if (qteStock != other.qteStock)
			return false;
		return true;
	}
	
	

}
