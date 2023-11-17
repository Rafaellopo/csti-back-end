package com.csti.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemLista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String atendimento;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime date;
	
	@JsonIgnore @ManyToOne @JoinColumn(name = "catalogo_id")
	private Catalogo catalogo;
	
	@JsonIgnore @ManyToOne @JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@JsonIgnore @ManyToOne @JoinColumn(name = "lista_id")
	public Lista lista;

	public ItemLista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemLista(Integer id, String atendimento, LocalDateTime date, Catalogo catalogo, Pessoa pessoa,
			Lista lista) {
		super();
		this.id = id;
		this.atendimento = atendimento;
		this.date = date;
		this.catalogo = catalogo;
		this.pessoa = pessoa;
		this.lista = lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
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
		ItemLista other = (ItemLista) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
