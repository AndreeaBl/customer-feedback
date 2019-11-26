package org.scrum.domain.services;

import java.util.Date;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.project.ProjectCurrentReleaseView;
import org.scrum.spring.AppScanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestPlanningProjectBusinessWorkflowServices {
	private static Logger logger = Logger.getLogger(TestPlanningProjectBusinessWorkflowServices.class.getName());
	
	@Autowired 
//	@Qualifier("PlanningProjectBusinessWorkflowServiceImpl")
	@Qualifier("proxyAuditedService")
	private IPlanningProjectBusinessWorkflowService planningProjectBusinessWorkflowService;
	
	@Test
	public void test1_WorkflowService() {
		logger.info("Domain Service implementation instance:: " + planningProjectBusinessWorkflowService);
		logger.info("Dpmain Service implementation class:: " + planningProjectBusinessWorkflowService.getClass().getName());
		
		Date tomorow = new Date(new Date().getTime() + 1000*60*60*24*1);
		// 1.
		Integer projectId = planningProjectBusinessWorkflowService.planNewProject("Planned.Test.Project", tomorow);
		// 2...
		planningProjectBusinessWorkflowService.addFeatureToProject(projectId, "Test.Feature_A", "Planned.Test");
		planningProjectBusinessWorkflowService.addFeatureToProject(projectId, "Test.Feature_B", "Planned.Test");
		planningProjectBusinessWorkflowService.addFeatureToProject(projectId, "Test.Feature_C", "Planned.Test");
		// 3.
		Date futureDateOf45Day = new Date(new Date().getTime() + 1000*60*60*24*45);
		planningProjectBusinessWorkflowService.planCurrentRelease(projectId, futureDateOf45Day);
		// 4.
		ProjectCurrentReleaseView viewData = planningProjectBusinessWorkflowService.getProjectSummaryData(projectId);
		// 
		logger.info(viewData.toString());
		
	}
}
