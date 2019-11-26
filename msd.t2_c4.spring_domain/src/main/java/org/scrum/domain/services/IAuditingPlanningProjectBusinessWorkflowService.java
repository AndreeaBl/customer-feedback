package org.scrum.domain.services;

import org.scrum.domain.project.Feature;
import org.scrum.domain.project.Project;

public interface IAuditingPlanningProjectBusinessWorkflowService {
	void auditProjectFeature(Integer projectId, String featureName);
}
