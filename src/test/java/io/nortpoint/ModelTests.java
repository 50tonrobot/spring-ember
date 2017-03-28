package io.nortpoint;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StartApplication.class)
public class ModelTests {
	
	@Test
	public void testSample() {
		assertEquals("Boom Test",1,1);
	}
	
	@Test
	public void testCase() {
		assertNotEquals(2, 1);
	}
	
	@Test
	public void testWhat() {
		assertEquals("How",1,1);
	}
}
