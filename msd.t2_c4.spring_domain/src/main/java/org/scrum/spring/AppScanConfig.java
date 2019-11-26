package org.scrum.spring;

import java.util.logging.Logger;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.scrum.domain.services.AuditingPlanningProjectBusinessWorkflowServiceImpl;
import org.scrum.domain.services.IAuditingPlanningProjectBusinessWorkflowService;
import org.scrum.domain.services.IPlanningProjectBusinessWorkflowService;
import org.scrum.domain.services.IProjectEntityFactory;
import org.scrum.domain.services.IProjectEntityRepository;
import org.scrum.domain.services.ProjectEntityFactoryBase;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = {"org.scrum.domain.services"})
public class AppScanConfig {
	private static Logger logger = Logger.getLogger(AppScanConfig.class.getName());
	
	@Bean
	public Validator initValidator() {
		logger.info("... Init VALIDATION CONTEXT.");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		return validator;
	}
	
	@Bean 
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Autowired @Qualifier("ProjectEntityFactoryBase")
	private IProjectEntityFactory entityFactory;
	
	// Auditing
	@Autowired @Qualifier("PlanningProjectBusinessWorkflowServiceImpl")
	private IPlanningProjectBusinessWorkflowService planningProjectBusinessWorkflowService;
	
	@Autowired
	private IAuditingPlanningProjectBusinessWorkflowService auditService;
	
	@Bean(name="proxyAuditedService")
	public IPlanningProjectBusinessWorkflowService entityFactory() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice((AfterReturningAdvice)auditService);
		pf.setTarget(planningProjectBusinessWorkflowService);
		IPlanningProjectBusinessWorkflowService proxyAuditedService = (IPlanningProjectBusinessWorkflowService) pf.getProxy();
		
		return proxyAuditedService;
	}
}
