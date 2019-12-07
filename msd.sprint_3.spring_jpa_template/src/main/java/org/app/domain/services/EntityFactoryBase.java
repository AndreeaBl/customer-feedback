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
	public Feedback feedbackAtasamente (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Atasament> listaAtasamente) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		List<Atasament> atasamente = new ArrayList<>();
		///Modifica crearea atasamnetului
		Atasament atasament = new Atasament(1, "R: " + feedback.getRootName() + "." + 1, feedback);
		atasamente.add(atasament);
		feedback.setAtasamente(atasamente);
		return feedback;
	}
	
	@Override
	public Feedback feedbackComentarii (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Comentariu> listaComentarii) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		List<Comentariu> comentarii = new ArrayList<>();
		///Modifica crearea comentariului
		Comentariu comentariu = new Comentariu(1, "R: " + feedback.getRootName() + "." + 1, feedback);
		comentarii.add(comentariu);
		feedback.setComentarii(comentarii);
		return feedback;
	}
	
	@Override
	public Feedback feedbackCerinte (Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Cerinta> listaCerinte) {
		logger.info(">>> Service: EntityFactoryBase :: creare Feedback cu Atasamente.");
		//
		Feedback feedback = new Feedback(name, status, proiect,user, dataInregistrare, title, descriere, tipFeedback);
		List<Cerinta> cerinte = new ArrayList<>();
		///Modifica crearea cerintei
		Cerinta cerinta = new Cerinta(1, "R: " + feedback.getRootName() + "." + 1, feedback);
		cerinte.add(cerinta);
		feedback.setCerintei(cerinte);
		return feedback;
	}
