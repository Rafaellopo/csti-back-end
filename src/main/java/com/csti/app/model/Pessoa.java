package com.csti.app.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status ;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, String nome, Status status, Cargo cargo, Equipe equipe) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.cargo = cargo;
		this.equipe = equipe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
}
