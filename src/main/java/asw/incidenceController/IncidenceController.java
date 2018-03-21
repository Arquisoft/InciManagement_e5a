package asw.incidenceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.dbManagement.model.Incidence;
import asw.incidenceController.services.AgentsService;
import asw.incidenceController.services.IncidenceService;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private AgentsService agentsService;
	
	//@Autowired
	//private KafkaService kafkaService;

	/*@RequestMapping(value = "/incidence/add", method = RequestMethod.POST) 
	public String createIncidence(@RequestParam String name, @RequestParam String description, @RequestParam String username, @RequestParam String password, @RequestParam String tags) {
		
		Incidence incidence = new Incidence(username, password,name,description,null);
	}*/
}
