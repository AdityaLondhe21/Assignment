package com;

import java.util.ArrayList;
import java.util.List;

public class ArrayOperations {
	private List<Integer> list = new ArrayList<Integer>();
	
	private static int callCount=0;
		
	int getCallCount() {
		return callCount;
	}
	void insertRandomElementsToArray(int n) {
		for(int i=0;i<n;i++) {
			list.add((int)Math.random()%100);
		}
		callCount++;
	}
	int getArraySize() {
		return list.size();
	}
	void clearArray() {
		list.clear();
	}
}
