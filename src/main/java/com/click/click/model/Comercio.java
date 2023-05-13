package com.click.click.model;



import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_comercios")
public class Comercio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!") 
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nomeComercio;
	
	@NotBlank(message = "O atributo endereco é Obrigatório!") 
	@Size(min = 1, max = 100, message = "O atributo endereco deve conter no mínimo 05 e no máximo 100 caracteres")
	private String enderecoComercio;
   
	@Nullable
	private String telefone;
	
	@Nullable
	private String horarioFuncionamento;
	
	@Nullable
	private String logoComercio;
	
	@Nullable
	private String imagemCardapio;

	@Nullable
	private String urlCardapio;
	
	@ManyToOne
	@JsonIgnoreProperties ("comercio")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties ("comercio")
	private Bairro bairro;
	


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeComercio() {
		return nomeComercio;
	}

	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}

	public String getEnderecoComercio() {
		return enderecoComercio;
	}

	public void setEnderecoComercio(String enderecoComercio) {
		this.enderecoComercio = enderecoComercio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public String getLogoComercio() {
		return logoComercio;
	}

	public void setLogoComercio(String logoComercio) {
		this.logoComercio = logoComercio;
	}

	public String getImagemCardapio() {
		return imagemCardapio;
	}

	public void setImagemCardapio(String imagemCardapio) {
		this.imagemCardapio = imagemCardapio;
	}

	public String getUrlCardapio() {
		return urlCardapio;
	}

	public void setUrlCardapio(String urlCardapio) {
		this.urlCardapio = urlCardapio;
	}

}
