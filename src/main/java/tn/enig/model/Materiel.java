package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Materiel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String titre;
	private String type;
	private int numserie;
	private int qte;
	private String etat;
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement dept;
	
	public Materiel() {
		super();

	}

	public Materiel(Integer id, String titre, String type, int numserie, int qte, String etat, Departement dept) {
		super();
		this.id = id;
		this.titre = titre;
		this.type = type;
		this.numserie = numserie;
		this.qte = qte;
		this.etat = etat;
		this.dept = dept;
	}

	private Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	private String getTitre() {
		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	private String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	private int getNumserie() {
		return numserie;
	}

	private void setNumserie(int numserie) {
		this.numserie = numserie;
	}

	private int getQte() {
		return qte;
	}

	private void setQte(int qte) {
		this.qte = qte;
	}

	private String getEtat() {
		return etat;
	}

	private void setEtat(String etat) {
		this.etat = etat;
	}

	private Departement getDept() {
		return dept;
	}

	private void setDept(Departement dept) {
		this.dept = dept;
	}
	
	
	
	
	

}
