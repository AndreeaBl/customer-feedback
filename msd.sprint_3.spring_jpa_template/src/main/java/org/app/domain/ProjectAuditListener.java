package org.app.domain;

import java.util.logging.Logger;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ProjectAuditListener {
	private static Logger logger = Logger.getLogger(ProjectAuditListener.class.getName());
	
	@PrePersist
    public void onPrePersist(RootEntity entity) {
		auditProject(entity, EntityOperation.ADDED);
	}
       
    @PreUpdate
    public void onPreUpdate(RootEntity entity) {
    	auditProject(entity, EntityOperation.UPDATED);
    }
       
    @PreRemove
    public void onPreRemove(RootEntity entity) {
    	auditProject(entity, EntityOperation.DELETED);
    }
    
    private void auditProject(RootEntity entity, EntityOperation operation) {
    	logger.info(">>> JPA ProjectAuditListener: " + entity + " > " + operation);
		
	}
    
    static public enum EntityOperation{
    	ADDED, UPDATED, DELETED;
    }
}
