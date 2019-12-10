package org.app.domain.services;

import java.util.logging.Logger;

import org.app.domain.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.app.domain.Feedback;


/*
 * Naming template: Action.ing Entity-name Service-type
 */
@Service
public class SummarizingAggregateServiceImpl implements ISummarizingAggregateService {
	private static Logger logger = Logger.getLogger(SummarizingAggregateServiceImpl.class.getName());
	//
	
	@Autowired
	public IEntityRepository er;
	
	//Numaram comentariile unui feedback
	@Override
	public Feedback countingComentarii(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingComentarii.");
		Integer id = feedback.getIdFeedback();
		Integer comentariuCount = (er.getComentariiByFeedbackId(id) == null) ? 0 : er.getComentariiByFeedbackId(id).size();
		feedback.setComentariuCount(comentariuCount);
		return feedback;
	}
	
	//Numaram atasamentele unui feedback
	@Override
	public Feedback countingAtasamente(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingAtasamente.");
		Integer id = feedback.getIdFeedback();
		Integer atasamentCount = (er.getAtasamentByFeedbackId(id) == null) ? 0 : er.getAtasamentByFeedbackId(id).size();
		feedback.setAtasamentCount(atasamentCount);
		return feedback;
	}
	
	//Numaram cerintele unui feedback
	@Override
	public Feedback countingCerinte(Feedback feedback) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingCerinte.");
		Integer id = feedback.getIdFeedback();
		Integer cerintaCount = (er.getCerintaByFeedbackId(id) == null) ? 0 : er.getCerintaByFeedbackId(id).size();
		feedback.setCerintaCount(cerintaCount);
		return feedback;
	} 
	
	
}
