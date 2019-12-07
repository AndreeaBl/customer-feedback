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
		
		List<Atasament> atasamente = new ArrayList<>();
		Integer nextID = this.entityRepository.getNextID();
		///Modifica crearea atasamentului
		Atasament atasament = new Atasament(nextID, "R: " + feedback.getRootName() + "." + 1, feedback);
		atasamente.add(atasament);
		feedback.setAtasamente(atasamente);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriAtasamente) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		
		List<Atasament> atasamente = new ArrayList<>();
		///Modifica crearea atasamentului
		for(Integer IdAtasamnet: IduriAtasamente) {
			atasamente.add(new Atasament(IdAtasament, "R: " + feedback.getRootName() + "." + 1, feedback);
		}
		feedback.setAtasamente(atasamente);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Comentariu (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Comentariu.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		List<Comentariu> comentarii = new ArrayList<>();
		
		Integer nextID = this.entityRepository.getNextID();
		///Modifica crearea comentariului
		Comentariu comentariu = new Comentariu(nextID, "R: " + feedback.getRootName() + "." + 1, feedback);
		comentarii.add(comentariu);
		feedback.setComentarii(comentarii);
		return feedback;
	}
	
	@Override
	public Feedback feedbackXComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriComentarii) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu comenatrii.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		
		List<Comentariu> comentarii = new ArrayList<>();
		///Modifica crearea comentariului
		for(Integer IdComenatriu: IduriComentarii) {
			comentarii.add( new Comentariu(IdComenatriu, "R: " + feedback.getRootName() + "." + 1, feedback);
		}
		feedback.setComentarii(comentarii);
		return feedback;
	}
	
	@Override
	public Feedback feedback1Cerinta (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu cerinta.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		List<Cerinta> cerinte = new ArrayList<>();
		///Modifica crearea cerintei
		Integer nextID = this.entityRepository.getNextID();
		Cerinta cerinta = new Cerinta(nextID, "R: " + feedback.getRootName() + "." + 1, feedback);
		cerinte.add(cerinta);
		feedback.setCerintei(cerinte);
		return feedback;
	}

	@Override
	public Feedback feedbackXCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Integer> IduriCerinte) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu ccerinte.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		
		List<Cerinta> cerinte = new ArrayList<>();
		///Modifica crearea cerintei
		for(Integer IdCerinta: IduriCerinte) {
			cerinte.add( new Cerinta(IdCerinta, "R: " + feedback.getRootName() + "." + 1, feedback);
		}
		feedback.setCerintei(cerinte);
		return feedback;
	}
	