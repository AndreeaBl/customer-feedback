package org.scrum.domain.services;

import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.app.domain.ComponentEntity;
import org.app.domain.RootEntity;
import org.app.domain.services.IEntityFactory;
import org.app.domain.services.IAggregateRepositorySpringData;
import org.app.spring.AppPersistenceEMFConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
 */

// Enable Spring JUnit runtime
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppPersistenceEMFConfig.class)
public class TestProjectEntityRepositorySpringData {
	
	private static Logger logger = Logger.getLogger(TestProjectEntityRepositorySpringData.class.getName());

	@Autowired
	private IEntityFactory entityFactory;

	@Autowired
	private IAggregateRepositorySpringData entityRepository;
	
	@Test 
	public void test() throws Exception{
		// Check CDI Beans (business services)
		logger.info("Repository implementation object:: " + entityRepository);
		logger.info("Repository implementation class:: " + entityRepository.getClass().getName());
		//
		logger.info("Factory implementation object:: " + entityFactory);
		logger.info("Factory implementation class:: " + entityFactory.getClass().getName());
		//
		tearDown();
		
		// Create and persist entities
		List<RootEntity> testEntities = new ArrayList<>();
		RootEntity testEntity;
		for(int i=1; i<=3; i++) {
			testEntity = entityFactory.buildAggregate("Root_" + i, new Date());
			
			testEntity.getComponents().add(new ComponentEntity(null, "Component", testEntity));
			
			testEntity = entityRepository.save(testEntity);
			testEntities.add(testEntity);
			logger.info("Saved project: " + testEntity);
		}
		
		// Check entity queries
		List<RootEntity> resultList = entityRepository.findByRootName("Root_1");
		logger.info(">>>> entityRepository.findByRootName >>>");
		resultList.stream().forEach(p->logger.info(" ==== " + p));
		logger.info("---------------------------------------------------------");
		
		resultList = entityRepository.findByName("Root");
		logger.info(">>>> entityRepository.findByName >>>");
		resultList.stream().forEach(p->logger.info(" ==== " + p));
		logger.info("---------------------------------------------------------");
		
		Integer testRootId = testEntities.get(0).getRootId();
		RootEntity result = entityRepository.findByRootId(testRootId);
		logger.info(">>>> entityRepository.findByRootId(testRootId) >>>");
		logger.info(" ==== " + result);
		logger.info("---------------------------------------------------------");
		
		// Clean all entities 
//		tearDown();
	}
	
	public void tearDown() throws Exception {
		Long entityCount = entityRepository.count();
		logger.info("entityCount before cleaning = " + entityCount);
		
		entityRepository.deleteAll();
		
		entityCount = entityRepository.count();
		logger.info("entityCount after cleaning = " + entityCount);
	}
}