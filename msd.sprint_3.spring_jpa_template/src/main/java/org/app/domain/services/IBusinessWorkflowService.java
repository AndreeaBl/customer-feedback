package org.app.domain.services;

import java.util.Date;

import org.app.domain.AggregateView;
import org.app.domain.Proiect;
import org.app.domain.Status;
import org.app.domain.User;

/*
 * Business Workflow Steps/Actions:
 * (1) ...
 * (2) ...
 * (3) ...
 */
public interface IBusinessWorkflowService {

	// (1) Start workflow
	Integer startWorkflow(Integer id, Status status, Proiect proiect, User user, Date deadline, String titlu, String descriere, String tipFeedback);

	// (2) Update Aggregate
	Integer updateAggregate(Integer rootId);

}