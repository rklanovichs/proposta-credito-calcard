package br.com.propostacredito.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import br.com.propostacredito.persistence.model.PropostaCreditoCliente;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe responsável pela definição de regras de negócio para validação de propósta de crédito.
 *
 */
@Rule(name = "Regra Casado Com Dependentes Com Renda Acima de 5000", description = "Regra Casado Com Dependentes Com Renda Acima de 5000")
public class CasadoComDependentesComRendaAcima5000Rule extends LimiteConfig{
	        
	@Condition
    public boolean when(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) {
    	if (propostaCreditoCliente == null) 
    		return false;
    	
    	renda = propostaCreditoCliente.getRenda();

    	if (propostaCreditoCliente.getEstadoCivil().equalsIgnoreCase("Casado(a)") && 
    			propostaCreditoCliente.getDependentes() >= 1 && 
    				renda >= 5000) {
    		return true;    		
    	} 
    	
    	else {
    		return false;
    	}
    }
 
    @Action
    public void thenAprovado(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) throws Exception {
    	propostaCreditoCliente.setResultadoAnalise(APROVADO);
    	renda = propostaCreditoCliente.getRenda();
    	limiteMinimoPercentual = (renda * 18.75) / 100;
    	limiteMaximoPercentual = (renda * 25) / 100;
    	String descricaoLimite = "Entre " + String.format("%.2f", limiteMinimoPercentual) + " - " + String.format("%.2f", limiteMaximoPercentual);
    	propostaCreditoCliente.setLimite(descricaoLimite);
    }
}