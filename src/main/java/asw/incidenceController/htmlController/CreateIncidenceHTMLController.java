package asw.incidenceController.htmlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.incidenceController.CreateIncidence;

@Controller
public class CreateIncidenceHTMLController {
	
	@Autowired
	private CreateIncidence incidenceCreator;

	@RequestMapping(value = "createIncidence", method = RequestMethod.GET)
	public String createIncidencePage() {
		return "createIncidence";
	}
	
	@RequestMapping(value = "createIncidence", method = RequestMethod.POST)
	public String createIncidence(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String tags) {
		
		return "createIncidence";
	}
	
}
