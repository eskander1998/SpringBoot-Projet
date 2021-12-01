package tn.esprit.spring.DAO.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Client")
public class Client implements Serializable {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")

private Long idClient; 

private String nom;

private String prenom;

private String email;

private String password;

@Temporal(TemporalType.DATE)
private Date dateNaissance;

@Enumerated (EnumType.STRING)
private Profession profession;

@Enumerated(EnumType.STRING)
private CategorieClient categorieClient;

@JsonIgnore
@OneToMany(mappedBy="client")
private Set<Facture> factures;



public Client() {
	super();
}




public Client(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance,
		Profession profession, CategorieClient categorieClient) {
	super();
	this.idClient = idClient;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.profession = profession;
	this.categorieClient = categorieClient;
}




public Long getIdClient() {
	return idClient;
}

public void setIdClient(Long idClient) {
	this.idClient = idClient;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getDateNaissance() {
	return dateNaissance;
}

public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}



public Profession getProfession() {
	return profession;
}



public void setProfession(Profession profession) {
	this.profession = profession;
}



public CategorieClient getCategorieClient() {
	return categorieClient;
}



public void setCategorieClient(CategorieClient categorieClient) {
	this.categorieClient = categorieClient;
}


}
