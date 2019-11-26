package org.scrum.domain.services;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.scrum.domain.project.ProjectAuditView;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Service;

@Service
// Auditing PlanningProjectBusinessWorkflowService :: addFeatureToProject
public class AuditingPlanningProjectBusinessWorkflowServiceImpl implements 
		IAuditingPlanningProjectBusinessWorkflowService, 
		MethodInterceptor, AfterReturningAdvice{
	private static Logger logger = Logger.getLogger(AuditingPlanningProjectBusinessWorkflowServiceImpl.class.getName());
	
	// Business Logic
	@Override
	public void auditProjectFeature(Integer projectId, String featureName) {
		logger.info("AUDIT INFO: " + new ProjectAuditView(
				projectId, featureName, 
				ProjectAuditView.EFeatureOperation.ADDED));
		
	}

	// AOP Invocation Logic
	@Override
	public Object invoke(MethodInvocation ic) throws Throwable {
		logger.info(">>>> SpringAOP.INTERCEPTION: Entering in LoggingInterceptor for: " 
					+ ic.getMethod().getName()
					+ ", " + ic.getStaticPart().getClass() 
					+ ", " + ic.getThis().getClass());
		try {
			if (ic.getMethod().getName().equals("addFeatureToProject")) {
				Integer projectId = (Integer) ic.getArguments()[0];
				String featureName = (String) ic.getArguments()[1];
				auditProjectFeature(projectId, featureName);
			}
			// invoke target
			return ic.proceed();
		} finally {
			logger.info(">>>> SpringAOP.INTERCEPTION: Exiting in LoggingInterceptor for: " + ic.getMethod().getName());
		}
	}
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// target is already invoked
		
		logger.info(">>>...>>> Spring.AOP.DECORATED INVOCATION: " + method.getName());
		if (method.getName().equals("addFeatureToProject")) {
			Integer newProjectId = (Integer) returnValue;
			
			// Decorated Business Logic
			Integer projectId = (Integer) args[0];
			String featureName = (String) args[1];
			auditProjectFeature(projectId, featureName);
	
			logger.info(">>>...>>> Spring.AOP.DECORATED PROJECT with features: " + newProjectId);
		}
		
	}
}
