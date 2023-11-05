package com.csti.app.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.csti.app.model.Status;

public class StatusDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	
	@NotEmpty(message = "Campo DESCRIÇÃO não pode ser nulo")
	
	private String descricao;

	public StatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusDTO(Status obj) {
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
		StatusDTO other = (StatusDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
