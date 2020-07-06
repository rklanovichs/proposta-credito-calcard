package br.com.propostacredito.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.propostacredito.persistence.model.PropostaCreditoCliente;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe repositório para interação com o banco de dados.
 *
 */

@Repository
public interface PropostaCreditoClienteRepository extends JpaRepository<PropostaCreditoCliente, Integer> {

}
