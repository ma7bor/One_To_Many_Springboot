package com.Pro.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






@Controller
public class MainController {
	
	@Autowired
	PersonneRepo IntPer;
	
	@Autowired
	ContratRepo IntCon;
	
	
	// for show welcome page
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Acceuil(Model model) {	
		 model.addAttribute("person",new PersonneEntity()); 
			return "index";
	}
	
	
	
	// for add new client info
	@RequestMapping(value="/ajouterpersonne", method=RequestMethod.POST)
	public String AddPerson(Model model,@Valid PersonneEntity person) {
		

		 IntPer.save(person);
		 ContratEntity ce= new ContratEntity();
		 
	model.addAttribute("contrat",ce); 
	model.addAttribute("idperson",person.getId()); 

	return "formcontrat";
	

		}
	
	// for add new contract for client
  @RequestMapping(value="/ajoutcontrat", method=RequestMethod.POST)
	public String AddContrat(Model model,ContratEntity contrat, long idperson) {		
	  
	  System.out.println(idperson);
	  
	  contrat.setPersonneEntity(IntPer.findById(idperson).get());
	  IntCon.save(contrat);		
	  
	  
	List<PersonneEntity> pe =new ArrayList<PersonneEntity>();
	pe=IntPer.findAll();
	model.addAttribute("persona",pe); 
	return "showlist";
	}
  
  
  // for show client list 
  @RequestMapping(value="/showlist", method=RequestMethod.GET)
	public String AddContrat(Model model) {		
	  
	List<PersonneEntity> pe =new ArrayList<PersonneEntity>();
	pe=IntPer.findAll();
	model.addAttribute("persona",pe); 
	return "showlist";
	}
  
    // for show contract based on id person
	@GetMapping("/contrat/{id}/show")
	public String showContrat(Model model,@PathVariable Long id){
		
		PersonneEntity p = IntPer.findById(id).get();
	
		model.addAttribute("contrats",p.getContratEntities());
		
		return "showlist2";
	}
  
	// for add contract based on id person
	@GetMapping("/contrat/add/{id}")
	public String pourAjouterContrat(Model model, @PathVariable("id") Long idprs) {
		
		model.addAttribute("idperson", idprs);
		model.addAttribute("contrat",new ContratEntity());
		return "formcontrat";
	}
	
	//for delete client from list 
	@RequestMapping(value = "/deleteClient", method=RequestMethod.GET) 
	public String deleteClient(Long id) {
		IntPer.deleteById(id);
		return"redirect:/showlist";
	}
	
	//for delete contract from list 
	@RequestMapping(value = "/deleteContract", method=RequestMethod.GET) 
	public String deleteContract(Long id) {
		IntCon.deleteById(id);
		return"redirect:/showlist";
	}
}
