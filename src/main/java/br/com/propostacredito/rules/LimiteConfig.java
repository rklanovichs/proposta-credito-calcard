package br.com.propostacredito.rules;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe de configuração.
 *
 */
public class LimiteConfig {
	
	Double limiteMinimoPercentual;
	Double limiteMaximoPercentual;
	Double renda;
	String descricaoLimite;
	
	public final String REPROVADO_PELA_POLITICA_DE_CREDITO = "Reprovado pela política de crédito";
	public final String APROVADO = "Aprovado";
	public final String NEGADO = "Negado";
	public final String RENDA_BAIXA = "Renda baixa";
	
	public Double getLimiteMinimoPercentual() {
		return limiteMinimoPercentual;
	}
	public void setLimiteMinimoPercentual(Double limiteMinimoPercentual) {
		this.limiteMinimoPercentual = limiteMinimoPercentual;
	}
	public Double getLimiteMaximoPercentual() {
		return limiteMaximoPercentual;
	}
	public void setLimiteMaximoPercentual(Double limiteMaximoPercentual) {
		this.limiteMaximoPercentual = limiteMaximoPercentual;
	}
	public Double getRenda() {
		return renda;
	}
	public void setRenda(Double renda) {
		this.renda = renda;
	}
	
	

}
