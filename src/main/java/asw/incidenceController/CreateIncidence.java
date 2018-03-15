package asw.incidenceController;

import asw.dbIncidence.model.Incidence;

public interface CreateIncidence {

	Incidence createIncidence(String user, String pass, String name, String description);
}
