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
@Rule(name = "Regra Casado Sem Dependentes Com Renda Acima de 2500", description = "Regra Casado Sem Dependentes Com Renda Acima de 2500")
public class CasadoSemDependentesComRendaAcima2500Rule extends LimiteConfig {
	
    @Condition
    public boolean when(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) {
    	if (propostaCreditoCliente == null) 
    		return false;

    	if (propostaCreditoCliente.getEstadoCivil().equalsIgnoreCase("Casado(a)") && 
    			propostaCreditoCliente.getDependentes() == 0 && 
    				propostaCreditoCliente.getRenda() >= 2500) {
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
    	limiteMinimoPercentual = (renda * 4) / 100;
    	limiteMaximoPercentual = (renda * 20) / 100;
    	descricaoLimite = "Entre " + String.format("%.2f", limiteMinimoPercentual) + " - " + String.format("%.2f", limiteMaximoPercentual);
    	propostaCreditoCliente.setLimite(descricaoLimite);
    }
}