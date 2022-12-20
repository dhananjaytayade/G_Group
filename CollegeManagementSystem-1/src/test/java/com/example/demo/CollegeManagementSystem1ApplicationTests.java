package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CollegeManagementSystem1ApplicationTests {
	
	Calculator c1=new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	void testsum() {
		int acutalresult=c1.dosum(10, 10);
		int expectedresullt=30;
		
		assertEquals(expectedresullt, acutalresult);
	}

}
