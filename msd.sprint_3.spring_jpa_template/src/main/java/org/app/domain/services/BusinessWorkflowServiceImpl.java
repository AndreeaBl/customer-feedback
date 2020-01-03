package org.app.domain.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

import org.app.domain.AggregateView;
import org.app.domain.Feedback;
import org.app.domain.Proiect;
import org.app.domain.RootEntity;
import org.app.domain.Status;
import org.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BusinessWorkflowServiceImpl")
@Transactional
public class BusinessWorkflowServiceImpl 
		implements IBusinessWorkflowService {
	private static Logger logger = Logger.getLogger(BusinessWorkflowServiceImpl.class.getName());
	
	// Support Services
	@Autowired
	private IAggregateRepositorySpringData entityRepository;
	
	@Autowired @Qualifier("EntityFactoryBase")
	private IEntityFactory entityFactory;
	
	// Spring Infrastructure Services
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	// Business Services
	@Autowired
	private ISummarizingAggregateService summarizingAggregateService;
	
	@Autowired
	private IConsolidatingAggregateService consolidatingAggregateService;
	
	// (1) Step_1 
	@Override
	public Integer startWorkflow(Integer id, Status status, Proiect proiect, User user, Date deadline, String titlu, String descriere, String tipFeedback) {
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: startWorkflow.");
		//
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Feedback feedbackNou = entityFactory.feedback1Atasament(id, status, proiect, user, deadline, titlu, descriere, tipFeedback);
		// Publish event to trigger ValidatingDomainService
		applicationEventPublisher.publishEvent(new DomainEvent(this, feedbackNou));
		//
		entityRepository.save(feedbackNou);
		return feedbackNou.getIdFeedback();
	}
	
	// (2) Step_2
	@Override
	public Integer updateAggregate(Integer feedbackId) {
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: updateAggregate.");
		//
		Feedback entity = entityRepository.findById(feedbackId).get();
		entity = summarizingAggregateService.countingAtasamente(entity);
		entity = summarizingAggregateService.countingComentarii(entity);
		entity = summarizingAggregateService.countingCerinte(entity);
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: updateAggregate DEBUG: " + entity);
		
		// Publish event to trigger ValidatingDomainService
		applicationEventPublisher.publishEvent(new DomainEvent(this, entity));
		//
		return entity.getIdFeedback();
	}

	
}
