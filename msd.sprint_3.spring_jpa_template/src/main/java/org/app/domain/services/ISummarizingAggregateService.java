package org.app.domain.services;

import org.app.domain.Feedback;
import org.app.domain.RootEntity;


public interface ISummarizingAggregateService {

	RootEntity countingComponents(RootEntity project);
	
	Feedback countingComentarii(Feedback feedback);
	
	Feedback countingAtasamente(Feedback feedback);
	
	Feedback countingCerinte(Feedback feedback);
	
}