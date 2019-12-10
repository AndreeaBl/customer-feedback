package org.app.domain.services;

import org.app.domain.Feedback;
import org.app.domain.RootEntity;


public interface ISummarizingAggregateService {

	
	Feedback countingComentarii(Feedback feedback);
	
	Feedback countingAtasamente(Feedback feedback);
	
	Feedback countingCerinte(Feedback feedback);
	
}