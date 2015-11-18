package com.annotation;

import com.annotation.TesterInfo.Priority;

@TesterInfo(priority = Priority.HIGH, createdBy = "gaana.com", tags = {
		"sales", "test" })
public class TestExample {

	@Test
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@Test(enable = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@Test(enable=true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

}
