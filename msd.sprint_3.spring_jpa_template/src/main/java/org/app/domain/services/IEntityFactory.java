package org.app.domain.services;

import java.util.Date;

import org.app.domain.RootEntity;

public interface IEntityFactory {

	///creare feedback cu atasamente
		public Feedback feedbackAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Atasament> listaAtasamente);
	
	///creare feedback cu comentarii
		public Feedback feedbackComentarii k(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Comentariu> listaComentarii);
			
	///creare feedback cu cerinte
		public Feedback feedbackCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
				String titlu, String descriere, String tipFeedback, List<Cerinta> listaCerinte);
		
	public void initDomainServiceEntities() ;
	
}
