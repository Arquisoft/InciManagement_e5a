package asw.incidenceController;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asw.dbManagement.model.Agent;
import asw.dbManagement.model.Incidence;
import asw.incidenceController.services.AgentsService;
import asw.incidenceController.services.IncidenceService;
import asw.kafkamanager.SendIncidenceImpl;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private AgentsService agentsService;
	
	@Autowired
	private SendIncidenceImpl sendIncidence;
	
	private SecureRandom random = new SecureRandom();
	
	@RequestMapping("/create")
	public String createSuggestion(@RequestParam String title, @RequestParam String descripcion,
			HttpSession session, Model model) 
	{
		if (descripcion.equals("")) 
		{
			model.addAttribute("mensajes", "No puedes dejar los campos de texto vacios");
			return "createIncidence";
			
		} 
		
		String identificador = nextId();
		Incidence incidence = incidenceService.saveIncidence(new Incidence(identificador, title, descripcion,
				(Agent) session.getAttribute("nombre")));
		sendIncidence.send(incidence.getIdentificador());
		return "index";
	}
	
	
	private String nextId() {
		return new BigInteger(130, random).toString(32);
	}
}
