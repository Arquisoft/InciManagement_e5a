package asw.incidenceController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.dbManagement.GetAgent;
import asw.dbManagement.model.Agent;
import asw.dbManagement.model.Incidence;
import asw.incidenceController.services.IncidenceService;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;

	//@Autowired
	//private KafkaService kafkaService;

	@Autowired
	private GetAgent getAgentService;
	
	@RequestMapping(value = "/sendIncidence", method = RequestMethod.GET)
	public String createIncidenceGet() {
		return "sendIncidence";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String createIncidence(@RequestParam String name, @RequestParam String description,
			@RequestParam String username, @RequestParam String password, @RequestParam String tags) {
		Agent agent = getAgentService.getAgent(username);
		if (agent == null || !agent.getPassword().equals(password))
			return "redirect:/sendIncidence?error";
		Incidence incidence = new Incidence(username, password, name, description, obtainTagsList(tags));
		incidenceService.addIncidence(incidence);
		
		return "sendIncidence";
	}
	
	private List<String> obtainTagsList(String str) {
		List<String> etiquetas = new ArrayList<>();
		Arrays.asList(str.split(",")).forEach(x -> {
			x.replace(" ", "");
			etiquetas.add(x.toLowerCase());
		});
		return etiquetas;
	}
}
