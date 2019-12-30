package org.app.domain.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.app.domain.Cerinta;
import org.app.domain.Comentariu;
import org.app.domain.Atasament;
import org.app.domain.Feedback;
import org.app.domain.Proiect;
import org.app.domain.Status;
import org.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("EntityFactoryBase")
@Scope("singleton")
public class EntityFactoryBase implements IEntityFactory {
	private static Logger logger = Logger.getLogger(EntityFactoryBase.class.getName());
	
	@Autowired
	private IAggregateRepositorySpringData entityRepository;
	
	@Autowired
	private IEntityRepository baseRepository;
	
	public EntityFactoryBase() {
		logger.info(">>> BEAN: EntityFactoryBase instantiated!");
	}
	
	@Override
	public Feedback feedback1Atasament (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasament.");
		//
				
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		Atasament atasament = new Atasament(1, user, feedback, "Fisier_"+1+"_Feedback_"+idFeedback, ".docx", new Date());
		
		baseRepository.addAtasamentToFeedback(atasament, feedback);
		
		return feedback;
		}
	
	@Override
	public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Atasament> atasamente) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		baseRepository.addAllAtasamentToFeedback(atasamente, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Comentariu.");
		//
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		Comentariu comentariu = new Comentariu(1, user, feedback, "Aici ar trebui sa fie textul comentariului 1", new Date());
		baseRepository.addComentariuToFeedback(comentariu, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Comentariu> comentarii) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu comenatrii.");
		//
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		baseRepository.addAllComenatiiToFeedback(comentarii, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1eCerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu cerinta.");
		//
		Date today = new Date();
		long ltime = today.getTime() + 7*24*60*1000;
		Date deadlineCerinta = new Date(ltime);
		
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		Cerinta cerinta = new Cerinta(1, user, user, feedback, "Descrierea cerintei", deadlineCerinta);
		baseRepository.addCerintaToFeedback(cerinta, feedback);
		return feedback;
	}

	@Override
	public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Cerinta> cerinte) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu ccerinte.");
		//
		Feedback feedback = new Feedback(idFeedback, status, proiect, user, new Date(), deadline, titlu, descriere, tipFeedback);
		baseRepository.addAllCerintaToFeedback(cerinte, feedback);
		return feedback;
	}

		@Override
		public void initDomainServiceEntities() {
			// TODO Auto-generated method stub
			
		}
}
