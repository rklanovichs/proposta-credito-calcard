package br.com.propostacredito.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.propostacredito.persistence.model.PropostaCreditoCliente;
import br.com.propostacredito.persistence.repository.PropostaCreditoClienteRepository;
import br.com.propostacredito.rules.PropostaCreditoClienteLauncherRules;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe Service contendo todos os serviços consumidos pela API Rest. 
 *
 */

@Service
public class PropostaCreditoClienteService {
	
	@Autowired
	PropostaCreditoClienteRepository propostaCreditoClienteRepository;
	
	@Autowired
	PropostaCreditoClienteLauncherRules propostaCreditoClienteLauncherRules;
	
	/**
	 * Método responsável por cadastrar uma propósta de crédito.
	 * 
	 * @param propostaCreditoCliente
	 * @return PropostaCreditoCliente
	 */
	public PropostaCreditoCliente addProposta(PropostaCreditoCliente propostaCreditoCliente) {
		propostaCreditoClienteLauncherRules.prepareAndFireRules(propostaCreditoCliente);
		return propostaCreditoClienteRepository.save(propostaCreditoCliente);
	}
	
	/**
	 * Método responsável por buscar todas as propóstas de crédito cadastradas.
	 * 
	 * @return Collection<PropostaCreditoCliente>
	 */
	public Collection<PropostaCreditoCliente> findPropostas() {
		return propostaCreditoClienteRepository.findAll();
	}
	
	/**
	 * Método responsável por buscar uma propósta de crédito cadastrada.
	 * 
	 * @param id
	 * @return Optional<PropostaCreditoCliente>
	 */
	public Optional<PropostaCreditoCliente> findById(Integer id) {
		return propostaCreditoClienteRepository.findById(id);
	}
	
	/**
	 * Método responsável por remover uma propósta de crédito cadastrada.
	 * 
	 * @param propostaCreditoCliente
	 */
	public void remove (PropostaCreditoCliente propostaCreditoCliente) {
		propostaCreditoClienteRepository.delete(propostaCreditoCliente);
	}

	/**
	 * Método responsável por buscar propóstas de crédito através do filtro selecionado.
	 * 
	 * @param propostaCreditoCliente
	 * @return Collection<PropostaCreditoCliente>
	 */
	public Collection<PropostaCreditoCliente> findPropostasBySearchFilter(PropostaCreditoCliente propostaCreditoCliente) {
		Example<PropostaCreditoCliente> example = Example.of(propostaCreditoCliente);
		return propostaCreditoClienteRepository.findAll(example);
	}
	
}
