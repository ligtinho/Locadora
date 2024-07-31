package locadora.filmes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Autowired	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {	
		return "home";
	}
	
	@GetMapping("/listarfilmes")
	public String listarfilmes() {	
		return "listarfilmes";
	}
	
	@GetMapping("/estoque")
	public String estoque() {	
		return "estoque";
	}
	
	@GetMapping("/sair")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
      
        return "redirect:/?logout";
    }
}
