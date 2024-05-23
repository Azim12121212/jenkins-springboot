package com.mjc.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {HelloController.class})
class JenkinsSpringbootApplicationTests {

	@Autowired
	private HelloController helloController;

	@Test
	void testGreetMessage() {
		String message = helloController.greet();
		Assertions.assertNotNull(message);
	}

	@Test
	void testHomePageMessage() {
		String message = helloController.getHomePage();
		Assertions.assertNotNull(message);
	}

	@Test
	void testMain() {
		JenkinsSpringbootApplication.main(new String[] {});
		Assertions.assertTrue(true);
	}

}
