package com.test.solution.main;

import com.test.solution.threads.Thread1;
import com.test.solution.threads.Thread2;

public class Main {
	
	public static void main(String[] args) {
		Object object1 = new Object();
		Object object2 = new Object();
		
		Thread1 thread1 = new Thread1(object1, object2);
		Thread2 thread2 = new Thread2(object1, object2);
		
		thread1.start();
		thread2.start();
		// Deadlocks can be resolved is synchronized blocks are in same order of object locks
		
	}

}
