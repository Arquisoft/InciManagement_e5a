package asw.incidenceController.impl;

import asw.dbManagement.model.Incidence;
import asw.incidenceController.CreateIncidence;


public class CreateIncidenceImpl implements CreateIncidence {

	public Incidence createIncidence(String user, String pass, String name, String description) {
		return new Incidence(user,pass,name,description,null);
	}
}
