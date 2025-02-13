package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayOperationsTest {
	static int arraySize=0;
	@Test
	void testInsertRandomElementsToArray() {
		ArrayOperations a1 = new ArrayOperations();
		arraySize+=10;
		a1.insertRandomElementsToArray(10);
		assertEquals(arraySize,a1.getArraySize(),"Array Size is not equal to "+arraySize);
		a1.clearArray();
		arraySize=0;
		assertEquals(0,a1.getArraySize(),"Array is not empty");
		
		arraySize=5;
		a1.insertRandomElementsToArray(5);
		assertEquals(arraySize,a1.getArraySize(),"Array Size is not equal to "+arraySize);
		
		a1.insertRandomElementsToArray(15);
		assertEquals(arraySize,a1.getArraySize(),"Array Size is not equal to "+arraySize);

		
		assertEquals(3,a1.getCallCount(),"Method insertRandomElementsToArray() is not being called 3 times");

	}

}
