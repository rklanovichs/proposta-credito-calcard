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
@Rule(name = "Regra Divorciado Sem Dependentes Com Renda Inferior a 2500", description = "Regra Divorciado Sem Dependentes Com Renda Inferior a 2500")
public class DivorciadoSemDependentesComRendaInferior2500Rule extends LimiteConfig {
        
	@Condition
    public boolean when(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) {
    	if (propostaCreditoCliente == null) 
    		return false;
    	
    	renda = propostaCreditoCliente.getRenda();

    	if (propostaCreditoCliente.getEstadoCivil().equalsIgnoreCase("Divorciado(a)") && 
    			propostaCreditoCliente.getDependentes() == 0 && renda < 2500) {
    		return true;    		
    	} 
    	
    	else {
    		return false;
    	}
    }
 
    @Action
    public void thenAprovado(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) throws Exception {
    	propostaCreditoCliente.setResultadoAnalise(NEGADO);
    	propostaCreditoCliente.setLimite(REPROVADO_PELA_POLITICA_DE_CREDITO);
    }
}