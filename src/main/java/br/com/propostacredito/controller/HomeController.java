package br.com.propostacredito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Robson Klanovichs
 * 
 * Classe controladora responsável por gerenciar a requisição HTTP /home.
 *
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goToHome() {
		return "index";
	}
}
