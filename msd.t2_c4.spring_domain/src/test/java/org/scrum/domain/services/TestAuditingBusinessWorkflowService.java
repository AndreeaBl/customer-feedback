package org.scrum.domain.services;

import java.util.Date;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.project.ProjectCurrentReleaseView;
import org.scrum.spring.AppScanConfig;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestAuditingBusinessWorkflowService {
	private static Logger logger = Logger.getLogger(TestAuditingBusinessWorkflowService.class.getName());
	
	@Autowired @Qualifier("PlanningProjectBusinessWorkflowServiceImpl")
	private IPlanningProjectBusinessWorkflowService planningProjectBusinessWorkflowService;
	
	@Autowired
	private IAuditingPlanningProjectBusinessWorkflowService auditingProjectFeatureDomainService; 
	
	@Test
	public void test1_AuditWorkflowService() {
		logger.info("Workflow Service implementation instance:: " + planningProjectBusinessWorkflowService);
		logger.info("Workflow Service implementation class:: " + planningProjectBusinessWorkflowService.getClass().getName());
		logger.info("Audit Domain Service implementation instance:: " + auditingProjectFeatureDomainService);
		logger.info("Audit Domain Service implementation class:: " + auditingProjectFeatureDomainService.getClass().getName());
		
		// Config AOP
		ProxyFactory pf = new ProxyFactory();
		// declare Advice
		pf.addAdvice((MethodInterceptor) auditingProjectFeatureDomainService);
		// define: target (pointcut)
		pf.setTarget(planningProjectBusinessWorkflowService);
		// get proxy-object that will wrap initial bean-object with an AOP aspect
		IPlanningProjectBusinessWorkflowService proxyService = (IPlanningProjectBusinessWorkflowService) pf.getProxy();
		
		// invoke business logic on AOP decorated-bean-object
		Date tomorow = new Date(new Date().getTime() + 1000*60*60*24*1);
		Integer projectId = proxyService.planNewProject("Planned.Test.Project", tomorow);
		proxyService.addFeatureToProject(projectId, "Test.Feature_A", "Planned.Test");
		proxyService.addFeatureToProject(projectId, "Test.Feature_B", "Planned.Test");
		proxyService.addFeatureToProject(projectId, "Test.Feature_C", "Planned.Test");
		
		Date futureDateOf45Day = new Date(new Date().getTime() + 1000*60*60*24*45);
		proxyService.planCurrentRelease(projectId, futureDateOf45Day);
		
		ProjectCurrentReleaseView viewData = proxyService.getProjectSummaryData(projectId);
		
		logger.info(viewData.toString());
		
	}
	
//	@Test
	public void test2_AuditWorkflowService() {
		logger.info("Workflow Service implementation instance:: " + planningProjectBusinessWorkflowService);
		logger.info("Workflow Service implementation class:: " + planningProjectBusinessWorkflowService.getClass().getName());
		logger.info("Audit Domain Service implementation instance:: " + auditingProjectFeatureDomainService);
		logger.info("Audit Domain Service implementation class:: " + auditingProjectFeatureDomainService.getClass().getName());
		
		// Config AOP: Defining an Aspect
		ProxyFactory pf = new ProxyFactory();
		// declare Advice
		pf.addAdvice((AfterReturningAdvice) auditingProjectFeatureDomainService);
		// define: target (pointcut)
		pf.setTarget(planningProjectBusinessWorkflowService);
		// get proxy-object that will wrap initial bean-object with an AOP aspect
		IPlanningProjectBusinessWorkflowService proxyService = (IPlanningProjectBusinessWorkflowService) pf.getProxy();
		// invoke AOP decorated-bean-object
		Integer projectId = proxyService.planNewProject("Planned.Test.Project", new Date());
		proxyService.addFeatureToProject(projectId, "Test.Feature_A", "Planned.Test");
		proxyService.addFeatureToProject(projectId, "Test.Feature_B", "Planned.Test");
		proxyService.addFeatureToProject(projectId, "Test.Feature_C", "Planned.Test");
		
		Date futureDateOf45Day = new Date(new Date().getTime() + 1000*60*60*24*45);
		proxyService.planCurrentRelease(projectId, futureDateOf45Day);
		
		ProjectCurrentReleaseView viewData = proxyService.getProjectSummaryData(projectId);
		
		logger.info(viewData.toString());
		
	}
	
	@Autowired @Qualifier("proxyAuditedService")
	private IPlanningProjectBusinessWorkflowService auditedService;
	
//	@Test
	public void test3_AuditWorkflowService() {
		logger.info("Workflow Service implementation instance:: " + planningProjectBusinessWorkflowService);
		logger.info("Workflow Service implementation class:: " + planningProjectBusinessWorkflowService.getClass().getName());
		logger.info("Audit Domain Service implementation instance:: " + auditingProjectFeatureDomainService);
		logger.info("Audit Domain Service implementation class:: " + auditingProjectFeatureDomainService.getClass().getName());
		
		Integer projectId = auditedService.planNewProject("Planned.Test.Project", new Date());
		auditedService.addFeatureToProject(projectId, "Test.Feature_A", "Planned.Test");
		auditedService.addFeatureToProject(projectId, "Test.Feature_B", "Planned.Test");
		auditedService.addFeatureToProject(projectId, "Test.Feature_C", "Planned.Test");
		
		Date futureDateOf45Day = new Date(new Date().getTime() + 1000*60*60*24*45);
		auditedService.planCurrentRelease(projectId, futureDateOf45Day);
		
		ProjectCurrentReleaseView viewData = auditedService.getProjectSummaryData(projectId);
		
		logger.info(viewData.toString());
		
	}
}
