package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class ATest {

	@Test
	void testXyz() {
//		Test interface without having access to its implementation
		A mockA = mock(A.class);
		mockA.xyz();
		mockA.xyz();
		mockA.xyz();
//		checking if method is called 3 times
		verify(mockA,times(3)).xyz();
		
//		checking for method returns void
		verify(mockA,times(1));
	}
	
}
