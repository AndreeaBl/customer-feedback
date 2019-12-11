package org.app.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.app.domain.ComponentEntity;
import org.app.domain.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("EntityFactoryBase")
@Scope("singleton")
public class EntityFactoryBase implements IEntityFactory {
	private static Logger logger = Logger.getLogger(EntityFactoryBase.class.getName());
	
	@Autowired
	private IAggregateRepositorySpringData entityRepository;
	
	public EntityFactoryBase() {
		logger.info(">>> BEAN: EntityFactoryBase instantiated!");
	}
	
	@Override
	public Feedback feedback1Atasament (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasament.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Atasament atasament = new Atasament(id, now());
		Atasament addAtasamentToFeedback(atasament, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, Collection<Atasamnete> atasamente) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Collection<Atasament> addAllAtasamentToFeedback(atasamente, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Comentariu.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Comentariu comentariu = new Comentariu(id, now());
		Comentariu addComentariuToFeedback(comentariu, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, Collection<Comentariu> comentarii) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu comenatrii.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		 Collection<Comentariu> addAllComenatiiToFeedback( comentarii, feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Cerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu cerinta.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Cerinta cerinta = new Cerinta(id, now());
		Cerinta addCerinteToFeedback(cerinta, feedback);
		return feedback;
	}

	@Override
	public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, Collection<Cerinta> cerinte) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu ccerinte.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Collection<Cerinta> addAllCerintaToFeedback(cerinte, feedback);
		return feedback;
	}
