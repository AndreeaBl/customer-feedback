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
		Atasament addAtasamentToFeedback(Atasament entity, Feedback feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriAtasamente) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Collection<Atasament> addAllAtasamentToFeedback(Collection<Atasament> entities, Feedback feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Comentariu.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Comentariu addComentariuToFeedback(Cerinta entity, Feedback feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriComentarii) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu comenatrii.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		 Collection<Comentariu> addAllComenatiiToFeedback(Collection<Cerinta> entities, Feedback feedback);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Cerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu cerinta.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Cerinta addCerinteToFeedback(Cerinta entity, Feedback feedback);
		return feedback;
	}

	@Override
	public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriCerinte) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu ccerinte.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		Collection<Cerinta> addAllCerintaToFeedback(Collection<Cerinta> entities, Feedback feedback);
		return feedback;
	}
