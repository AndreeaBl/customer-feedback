package org.scrum.domain.services;

import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.spring.AppScanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestProjectDomainService {
	private static Logger logger = Logger.getLogger(TestProjectDomainService.class.getName());

	@Autowired
	private IProjectDomainService service;
	
	@Autowired @Qualifier("ProjectEntityFactoryBase")
	private IProjectEntityFactory entityFactory;
	
//	@Autowired
//	private IProjectEntityRepository entityRepository;
	
	@Test
	public void test() {
		logger.info("Service implementation autowired xml:: " + service);
		logger.info("Service implementation autowired xml:: " + service.getClass().getName());
//		entityFactory.initDomainServiceEntities();
		//
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count autowired xml:: " + featureCount);
	}
	
}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/
