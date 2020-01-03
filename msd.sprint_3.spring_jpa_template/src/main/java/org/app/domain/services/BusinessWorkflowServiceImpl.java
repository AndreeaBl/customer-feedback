package org.app.domain.services;

import java.util.Date;
import java.util.logging.Logger;

import org.app.domain.AggregateView;
import org.app.domain.RootEntity;
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
	public Integer startWorkflow(String name, Date startDate) {
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: startWorkflow.");
		//
		RootEntity entity = entityFactory.buildAggregate(name, startDate);
		// Publish event to trigger ValidatingDomainService
		applicationEventPublisher.publishEvent(new DomainEvent(this, entity));
		//
		entityRepository.save(entity);
		return entity.getRootId();
	}
	
	// (2) Step_2
	@Override
	public Integer updateAggregate(Integer entityRootId) {
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: updateAggregate.");
		//
		RootEntity entity = entityRepository.findById(entityRootId).get();
		entity = summarizingAggregateService.countingComponents(entity);
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: updateAggregate DEBUG: " + entity);
		
		// Publish event to trigger ValidatingDomainService
		applicationEventPublisher.publishEvent(new DomainEvent(this, entity));
		//
		return entity.getRootId();
	}
	
	// (3) Step_3 Get aggregate summary data
	@Override
	public AggregateView getAggregateSummaryData(Integer entityRootId) {
		logger.info(">>> Service: BusinessWorkflowServiceImpl :: getAggregateSummaryData.");
		//
		RootEntity entity = entityRepository.findById(entityRootId).get();
		//
		return consolidatingAggregateService.countingComponents(entity);
	}

	
}
