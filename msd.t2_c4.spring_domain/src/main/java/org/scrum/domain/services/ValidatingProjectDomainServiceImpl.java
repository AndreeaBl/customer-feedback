package org.scrum.domain.services;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.scrum.domain.project.Project;
import org.scrum.domain.project.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ValidatingProjectDomainServiceImpl 
	implements ApplicationListener<DomainEvent>, 
		IValidatingProjectDomainService{
	private static Logger logger = Logger.getLogger(ValidatingProjectDomainServiceImpl.class.getName());
	
	@Autowired
	private Validator validator;
	
	//
	@Override
	public Set<String> validate(Project project){
		// .validate(entity), .validateProperty(entity, "propName")
		// .validateValue(ClassName.class, "propName", value)
		Set<ConstraintViolation<Project>> violations = validator
				.validate(project);
		logger.info("Violations count: " + violations.size());
		
		
		return violations.stream()
				.map(violation -> violation.getMessage() + " (" 
							+ violation.getInvalidValue() + ") is an invalid value!" )
				.collect(Collectors.toSet()); 
	}
	
	@Override
	public void validateWithException(Project project){
		Set<String> violations = validate(project);
		logger.info("Violations count (to generate exception): " + violations.size());
		
		if (violations.size() > 0) {
			String violationExceptionMessage = violations.stream()
					.map(violation -> ">>> JEE.Spring bean validator exception: " + violation)
					.collect(Collectors.joining(", "));
			try {
				validateProjectAggregate(project);
			}catch(Exception ex) {
				violationExceptionMessage += " Local validation: "
						+ ex.getMessage();
			}
			throw new RuntimeException(violationExceptionMessage);
		}
	}
	
	// Event-based Business Service Integration
	// SpringEvents:: Listening
	@Override
	public void onApplicationEvent(DomainEvent domainEvent) {
		Project buildProject = domainEvent.getMessage();
		logger.info(">>>***Validating_ListeningEvents***>>> for: " + domainEvent.getMessage());
		this.validateWithException(buildProject);
	}
	
	private boolean validateProjectAggregate(Project p) {
		if (p == null)
			throw new RuntimeException("Null Project!");
		if (p.getReleases() == null || p.getReleases().size() == 0)
			throw new RuntimeException("Null Releases!");
		else {
			//for(Release r: p.getReleases()) {
				if (p.getCurrentRelease().getFeatures() == null || p.getCurrentRelease().getFeatures().isEmpty())
					throw new RuntimeException("Null Features!");
			//}
		}
		return true;
	}
}
