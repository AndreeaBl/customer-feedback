 package org.scrum.domain.services;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.project.Project;
import org.scrum.spring.AppScanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
* https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
*/

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestValidatingDomainServices {
	private static Logger logger = Logger.getLogger(TestValidatingDomainServices.class.getName());
	
	// Support Services
	@Autowired
	private IProjectEntityRepository entityRepository;
	
	@Autowired @Qualifier("ProjectEntityFactoryBase")
	private IProjectEntityFactory entityFactory;
	
	// Test ValidatingProjectDomainService by event-forwarding pattern
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
//	@Test
	public void test1_ValidatingProjectDomainService() {
		// entityFactory.initDomainServiceEntities();
		Project project = entityRepository.getById(3);
		
		project.setName(null);
		project.setReleases(null);
		System.out.println("Project to be validated: " + project);
		
		try {
			applicationEventPublisher
				.publishEvent(new DomainEvent(this, project));
		}catch(Exception ex) {
			logger.severe(ex.getMessage());
		}
	}
	//
	
	@Autowired
	IValidatingProjectDomainService validatorService;
	
	@Test
	public void test2_ValidatingProjectDomainService() {
		Project project = entityRepository.getById(3);
		
		project.setName(null);
		System.out.println("Project to be validated: " + project);
		
		try {
			validatorService.validateWithException(project);
		}catch(Exception ex) {
			logger.severe(ex.getMessage());
		}
	}
}