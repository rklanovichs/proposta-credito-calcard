package br.com.propostacredito.rules;

import org.jeasy.rules.api.Facts;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Component;

import br.com.propostacredito.persistence.model.PropostaCreditoCliente;

/**
 * 
 * @author Robson Klanovichs
 *
 * Classe responsável por preparar e executar as regras de négocios definidas.
 * 
 */
@Component
public class PropostaCreditoClienteLauncherRules {
	
	@SuppressWarnings("deprecation")
	public PropostaCreditoCliente prepareAndFireRules (PropostaCreditoCliente propostaCreditoCliente) {
		
		Facts facts = new Facts();
        facts.add("propostaCreditoCliente", propostaCreditoCliente);
 
        Rules rules = new Rules();
        
        RulesEngine rulesEngine = new DefaultRulesEngine();        
        rules.register(new SolteiroSemDependentesComRendaEntre1000e2499Rule());        
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new SolteiroSemDependentesComRendaAcima2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new SolteiroComDependentesComRendaAcima2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new SolteiroSemDependentesComRendaInferior1000Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new SolteiroComDependentesComRendaInferior2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new CasadoSemDependentesComRendaAcima2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new CasadoComDependentesComRendaAcima5000Rule());
        rulesEngine.fire(rules, facts);

        rules = new Rules();
        rules.register(new ViuvoSemDependentesComRendaEntre2500a4999Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new ViuvoComDependentesComRendaAcima5000Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new ViuvoSemDependentesComRendaInferior2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new ViuvoComDependentesComRendaInferior5000Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new DivorciadoSemDependentesComRendaAcima2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new DivorciadoComDependentesComRendaAcima5000Rule());
        rulesEngine.fire(rules, facts);                    
                
        rules = new Rules();
        rules.register(new DivorciadoComDependentesComRendaInferior5000Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new DivorciadoSemDependentesComRendaInferior2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new CasadoSemDependentesComRendaInferior2500Rule());
        rulesEngine.fire(rules, facts);
        
        rules = new Rules();
        rules.register(new CasadoComDependentesComRendaInferior5000Rule());
        rulesEngine.fire(rules, facts);        
        
        System.out.println("Estado Civil: " + propostaCreditoCliente.getEstadoCivil());
        System.out.println("Resultado Analise: " + propostaCreditoCliente.getResultadoAnalise());
        System.out.println("Limite de credito: " + propostaCreditoCliente.getLimite());
		
		return propostaCreditoCliente;
	}
}
