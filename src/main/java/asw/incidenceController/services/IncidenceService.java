package asw.incidenceController.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.model.Incidence;
import asw.dbManagement.repository.IncidenceRepository;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	public void addIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
	}
}
