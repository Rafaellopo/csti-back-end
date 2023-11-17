package com.csti.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Catalogo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo SETOR não pode ser vazio")
	@Length(min = 5, message = "O campo SETOR só pode ter 5 caracteres")
	private String setor;
	
	@NotEmpty(message = "O campo PRÉDIO não pode ser vazio")
	@Length(min = 4, message = "O campo PRÉDIO tem que ter no mínimo 4 caracteres")
	private String predio;
	
	@NotEmpty(message = "O campo ANDAR não pode ser vazio")
	@Length(min = 5, message = "O campo ANDAR tem que ter no mínimo 5 caracteres")
	private String andar;
	
	@NotEmpty(message = "O campo SALA não pode ser vazio")
	@Length(min = 1, message = "O campo SALA tem que ter no mínimo 1 caracter")
	private Integer sala;
	
	@OneToMany(mappedBy = "catalogo")
	private List<ItemLista> itens = new ArrayList<>();

	public Catalogo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalogo(Integer id, String setor, String predio, String andar, Integer sala) {
		super();
		this.id = id;
		this.setor = setor;
		this.predio = predio;
		this.andar = andar;
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public List<ItemLista> getItens() {
		return itens;
	}

	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalogo other = (Catalogo) obj;
		return Objects.equals(id, other.id);
	}

}
