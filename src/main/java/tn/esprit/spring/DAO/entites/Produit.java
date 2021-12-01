package tn.esprit.spring.DAO.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; // Clé primaire
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;
	
	@OneToMany(mappedBy="Produit")
	private Set<DetailFacture> DetailFactures;
	
	@OneToOne
	private DetailProduit DetailProduit;
	
	@ManyToOne
	Stock stock;
	
	@ManyToOne
	Rayon rayon;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseurs;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getLibelleProduit() {
		return libelleProduit;
	}
	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Produit(Long idProduit, String codeProduit, String libelleProduit, float prixUnitaire) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
	}
	public Produit() {
		super();
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public Set<DetailFacture> getDetailFactures() {
		return DetailFactures;
	}
	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		DetailFactures = detailFactures;
	}
	public DetailProduit getDetailProduit() {
		return DetailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		DetailProduit = detailProduit;
	}
	public Set<Fournisseur> getFournisseurs() {
		return Fournisseurs;
	}
	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		Fournisseurs = fournisseurs;
	}
	
	
	
}
