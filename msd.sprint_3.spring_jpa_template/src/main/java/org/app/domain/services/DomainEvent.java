package org.app.domain.services;

import org.app.domain.Feedback;
import org.springframework.context.ApplicationEvent;

public class DomainEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	//
	private Feedback message;
	
	public DomainEvent(Object source) {
		super(source);
	}

	public DomainEvent(Object source, Feedback message) {
		super(source);
		this.message = message;
	}
	
	public Feedback getMessage() {
		return message;
	}
}

// https://www.baeldung.com/spring-events