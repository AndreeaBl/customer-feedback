package org.app.domain.services;

import java.util.Date;

import org.app.domain.RootEntity;

public interface IEntityFactory {

	///creare feedback cu X atasamente
		public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Integer> IduriAtasamente);
	
	///creare feedback cu X comentarii
		public Feedback feedbackXComentarii k(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Integer> IduriComentarii);
			
	///creare feedback cu X cerinte
		public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Integer> IduriCerinte);
		
	///creare feedback cu atasament
		public Feedback feedback1Atasament (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback);
		
	///creare feedback cu comentariu
		public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback);
		
	///creare feedback cu cerinta
		public Feedback feedback1eCerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback);
		
		public void initDomainServiceEntities() ;
	
}
