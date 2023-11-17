package com.csti.app.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.csti.app.model.Lista;

public class ListaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String descricao;
	
	private LocalDateTime date;
	
	private String equipe;
	
	private Integer equipeId;

	public ListaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaDTO(Lista obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.date = obj.getDate();
		this.equipe = obj.getEquipe().getDescricao();
		this.equipeId = obj.getEquipe().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public Integer getEquipeId() {
		return equipeId;
	}

	public void setEquipeId(Integer equipeId) {
		this.equipeId = equipeId;
	}
	
	
	
}
