package asw.incidenceController.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.model.Incidence;
import asw.dbManagement.repository.IncidenceRepository;
import asw.kafkamanager.SendIncidenceImpl;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private SendIncidenceImpl sender;
	
	public void addIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
	}
	
	public void sendIncidence(Incidence incidence) {
		
	}
}
