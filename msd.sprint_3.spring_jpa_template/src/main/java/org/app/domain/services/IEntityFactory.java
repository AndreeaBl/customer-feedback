package org.app.domain.services;

import java.util.Date;
import java.util.List;

import org.app.domain.Atasament;
import org.app.domain.Cerinta;
import org.app.domain.Comentariu;
import org.app.domain.Feedback;
import org.app.domain.Proiect;
import org.app.domain.RootEntity;
import org.app.domain.Status;
import org.app.domain.User;

public interface IEntityFactory {

	
	///creare feedback cu X atasamente
		public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Atasament> atasamente);
	
	///creare feedback cu X comentarii
		public Feedback feedbackXComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Comentariu> comentarii);
			
	///creare feedback cu X cerinte
		public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Cerinta> cerinte);
		
	///creare feedback cu atasament
		public Feedback feedback1Atasament (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback);
		
	///creare feedback cu comentariu
		public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback);
		
	///creare feedback cu cerinta
		public Feedback feedback1eCerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
				String titlu, String descriere, String tipFeedback);
		
		public void initDomainServiceEntities() ;
	
}
