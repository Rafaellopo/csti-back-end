package com.csti.app.dtos;

import java.io.Serializable;

import com.csti.app.model.Equipe;

public class EquipeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String descricao;

	public EquipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipeDTO(Equipe obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
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
	
	
	
	

}
