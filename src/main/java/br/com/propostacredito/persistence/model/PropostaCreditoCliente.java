package br.com.propostacredito.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe entidade responsável por mapear a tabela no banco de dados.
 *
 */

@Entity
@Table(name = "proposta_credito_cliente")
public class PropostaCreditoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	private String sexo;
	@Column(name = "estado_civil")
	private String estadoCivil;
	private String uf;
	private Integer dependentes;
	private Double renda;
	@Column(name = "resultado_analise")
	private String resultadoAnalise;
	private String limite;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public String getResultadoAnalise() {
		return resultadoAnalise;
	}

	public void setResultadoAnalise(String resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}
}
