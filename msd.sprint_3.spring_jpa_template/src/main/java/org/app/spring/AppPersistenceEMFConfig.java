package org.app.spring;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.aopalliance.intercept.MethodInterceptor;
//import org.domain.patterns.EntityRepositoryBase;
//import org.scrum.domain.project.Project;
//import org.scrum.domain.services.IAuditingProjectEntityRepositoryService;
//import org.scrum.domain.services.IProjectRepositorySpringData;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "org.app.domain.services", "org.domain.patterns" })
// JpaRelated Config :: META-INF/persistence.XML-based JPA configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.app.domain.services")
public class AppPersistenceEMFConfig extends AppScanConfig {
	private static Logger logger = Logger.getLogger(AppPersistenceEMFConfig.class.getName());

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MSD_LOCAL");
		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}

	/*
	//
	@Bean("projectBaseRepository")
	public EntityRepositoryBase<Project> entityRepository() {
		return new EntityRepositoryBase<Project>(Project.class);
	}

	//
	@Autowired
	private IAuditingProjectEntityRepositoryService auditingProjectEntityRepository;

	@Autowired
	private IProjectRepositorySpringData entityRepository;

	@Bean(name = "InterceptedProjectEntityRepositoryJPA")
	public IProjectRepositorySpringData projectRepositorySpringData() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice((MethodInterceptor) auditingProjectEntityRepository);
		pf.setTarget(entityRepository);
		IProjectRepositorySpringData proxyAuditedService = (IProjectRepositorySpringData) pf.getProxy();
		logger.info("Producing IProjectRepositorySpringData component.");
		return proxyAuditedService;
	}
	*/
}
