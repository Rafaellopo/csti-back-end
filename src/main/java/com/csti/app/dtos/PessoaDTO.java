package com.csti.app.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import com.csti.app.model.Pessoa;

public class PessoaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	private Integer statusId;
	
	@NotEmpty
	private String status;
	
	private Integer cargoId;
	
	@NotEmpty
	private String cargo;
	
	private Integer equipeId;
	
	@NotEmpty
	private String equipe;

	public PessoaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.statusId = obj.getStatus().getId();
		this.status = obj.getStatus().getDescricao();
		this.cargoId = obj.getCargo().getId();
		this.cargo = obj.getCargo().getDescricao();
		this.equipeId = obj.getEquipe().getId();
		this.equipe = obj.getEquipe().getDescricao();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	public Integer getEquipeId() {
		return equipeId;
	}

	public void setEquipeId(Integer equipeId) {
		this.equipeId = equipeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
