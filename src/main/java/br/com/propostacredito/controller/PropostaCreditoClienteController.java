package br.com.propostacredito.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.propostacredito.persistence.model.PropostaCreditoCliente;
import br.com.propostacredito.service.PropostaCreditoClienteService;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe Controladora Rest responsável por interceptar e resolver as requisições HTTP.
 *
 */

@RestController
public class PropostaCreditoClienteController {
	
	@Autowired
	PropostaCreditoClienteService propostaCreditoClienteService;
	
	@ApiOperation(value = "Método responsável por cadastrar uma propósta e realizar a análise de crédito para o cliente.")
	@RequestMapping(method=RequestMethod.POST, value="/proposta-credito-cliente", 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PropostaCreditoCliente> addProposta(@RequestBody PropostaCreditoCliente propostaCreditoCliente) {
		PropostaCreditoCliente propostaAdded = propostaCreditoClienteService.addProposta(propostaCreditoCliente);
		
		return new ResponseEntity<PropostaCreditoCliente>(propostaAdded, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Método responsável por buscar todas as propóstas de crédito previamente cadastradas e analisadas.")
	@RequestMapping(method=RequestMethod.GET, value="/proposta-credito-cliente", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<PropostaCreditoCliente>> findPropostas() {
		Collection<PropostaCreditoCliente> propostas = propostaCreditoClienteService.findPropostas();
		
		return new ResponseEntity<>(propostas,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Método responsável por remover uma propósta de crédito cadastrada.")
	@RequestMapping(method=RequestMethod.DELETE, value="/propostas/{id}")
	public ResponseEntity<PropostaCreditoCliente> removeProposta(@PathVariable Integer id) {
		
		PropostaCreditoCliente propostaFound= propostaCreditoClienteService.findById(id).get();
		if (propostaFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		propostaCreditoClienteService.remove(propostaFound);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Método responsável por buscar as propóstas de crédito previamente cadastradas e analisadas de acordo com o filtro preenchido.")
	@RequestMapping(method=RequestMethod.POST, value="/find-propostas", 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<PropostaCreditoCliente>> findBySearchFilter(@RequestBody PropostaCreditoCliente propostaCreditoCliente) {
		Collection<PropostaCreditoCliente> propostas = propostaCreditoClienteService.findPropostasBySearchFilter(propostaCreditoCliente);
		
		return new ResponseEntity<>(propostas, HttpStatus.OK);
		
	}

}
