package org.app.domain.services;

import java.util.logging.Logger;

import org.app.domain.RootEntity;
import org.springframework.stereotype.Service;
import org.app.domain.Feedback;


/*
 * Naming template: Action.ing Entity-name Service-type
 */
@Service
public class SummarizingAggregateServiceImpl implements ISummarizingAggregateService {
	private static Logger logger = Logger.getLogger(SummarizingAggregateServiceImpl.class.getName());
	//
	@Override
	public RootEntity countingComponents(RootEntity rootEntity) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingComponents.");
		Integer componentsCount = (rootEntity.getComponents() == null) ? 0 : rootEntity.getComponents().size();
		rootEntity.setComponentsCount(componentsCount);
		return rootEntity;
	}
	
	@Override
	public Feedback countingComentarii(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingComentarii.");
		Integer comentariuCount = (feedback.getListaComentarii() == null) ? 0 : feedback.getListaComentarii().size();
		feedback.setComentariuCount(comentariuCount);
		return feedback;
	}
	
	@Override
	public Feedback countingAtasamente(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingAtasamente.");
		Integer atasamentCount = (feedback.getListaAtasamente() == null) ? 0 : feedback.getListaAtasamente().size();
		feedback.setAtasamentCount(atasamentCount);
		return feedback;
	}
	
	@Override
	public Feedback countingCerinte(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingCerinte.");
		Integer cerintaCount = (feedback.getListaCerinte() == null) ? 0 : feedback.getListaCerinte().size();
		feedback.setCerintaCount(cerintaCount);
		return feedback;
	} 
	
	
}
