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
@Rule(name = "Regra Solteiro Sem Dependentes Com Renda Inferior a 1000", description = "Regra Solteiro Sem Dependentes Com Renda Inferior a 1000")
public class SolteiroSemDependentesComRendaInferior1000Rule extends LimiteConfig{
	
    @Condition
    public boolean when(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) {
    	if (propostaCreditoCliente == null) 
    		return false;

    	if (propostaCreditoCliente.getEstadoCivil().equalsIgnoreCase("Solteiro(a)") && 
    			propostaCreditoCliente.getDependentes() == 0 && 
    				propostaCreditoCliente.getRenda() < 1000) {
    		return true;    		
    	} 
    	
    	else {
    		return false;
    	}
    }
 
    @Action
    public void thenNegado(@Fact("propostaCreditoCliente") PropostaCreditoCliente propostaCreditoCliente) throws Exception {
    	propostaCreditoCliente.setResultadoAnalise(NEGADO);    	
    	propostaCreditoCliente.setLimite(RENDA_BAIXA);
    }
}