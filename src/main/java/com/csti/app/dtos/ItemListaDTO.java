package com.csti.app.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import com.csti.app.model.ItemLista;

public class ItemListaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String atendiemento;
	
	private LocalDateTime date;
	
	private Integer catalogo_id;
	
	private String catalogo;
	
	private Integer lista_id;
	
	private String lista;
	
	private Integer pessoa_id;
	
	private String pessoa;
	
	
	public ItemListaDTO() {
		// TODO Auto-generated constructor stub
	
		
	}


	public ItemListaDTO(ItemLista  itens) {
		super();
		this.id = itens.getId();
		this.atendiemento = itens.getAtendimento();
		this.date = itens.getDate();
		this.catalogo_id = itens.getCatalogo().getId();
		this.catalogo = itens.getCatalogo().getSetor();
		this.lista_id = itens.getLista().getId();
		this.lista = itens.getLista().getDescricao();
		this.pessoa_id = itens.getPessoa().getId();
		this.pessoa = itens.getPessoa().getNome();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAtendiemento() {
		return atendiemento;
	}


	public void setAtendiemento(String atendiemento) {
		this.atendiemento = atendiemento;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Integer getCatalogo_id() {
		return catalogo_id;
	}


	public void setCatalogo_id(Integer catalogo_id) {
		this.catalogo_id = catalogo_id;
	}


	public String getCatalogo() {
		return catalogo;
	}


	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}


	public Integer getLista_id() {
		return lista_id;
	}


	public void setLista_id(Integer lista_id) {
		this.lista_id = lista_id;
	}


	public String getLista() {
		return lista;
	}


	public void setLista(String lista) {
		this.lista = lista;
	}


	public Integer getPessoa_id() {
		return pessoa_id;
	}


	public void setPessoa_id(Integer pessoa_id) {
		this.pessoa_id = pessoa_id;
	}


	public String getPessoa() {
		return pessoa;
	}


	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	

}
