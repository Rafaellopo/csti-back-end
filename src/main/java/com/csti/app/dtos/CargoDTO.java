package com.csti.app.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.csti.app.model.Cargo;

public class CargoDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String descricao;
	
	
	public CargoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CargoDTO(Cargo obj) {
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
		CargoDTO other = (CargoDTO) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
