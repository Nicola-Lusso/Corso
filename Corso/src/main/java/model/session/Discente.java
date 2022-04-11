package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HB_DISCENTE")
public class Discente {
	
//	public static final String PROPERTY_matricola = "titolo_di_studio";

	
	public static final String PROPERTY_matricola = "matricola";
	public static final String PROPERTY_cognome = "cognome";
	public static final String PROPERTY_nome = "nome";

	@Column(name = "matricola")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matricola;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "nome")
	private String nome;


	public int getMatricola() {
		return matricola;
	}

	public void setMagtricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public String getTitoloDiStudio() {
//		return titoloDiStudio;
//	}
//
//	public void setTitoloDiStudio(String titoloDiStudio) {
//		this.titoloDiStudio = titoloDiStudio;
//	}



}
