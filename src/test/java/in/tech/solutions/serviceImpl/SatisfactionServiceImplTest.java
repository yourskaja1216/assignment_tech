package in.tech.solutions.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import in.tech.solutions.model.BaseEntity;
import in.tech.solutions.service.SatisfactionService;

@RunWith(SpringRunner.class)
public class SatisfactionServiceImplTest {

	@Autowired
	SatisfactionService satisfactionService;

	@Test
	public void testFindMaxSatisfaction() {
		

		satisfactionService.findMaxSatisfaction(null);
	}
}
