package com.test.solution.threads;

public class Thread1 extends Thread {
	private Object object1;
	private Object object2;
	
	public Thread1(Object o1, Object o2) {
		this.object1 = o1;
		this.object2 = o2;
	}
	
	@Override
	public void run() {
		synchronized (object1) {
			System.out.println("Object1 is in the lock & waiting for Object 2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		synchronized (object2) {
			System.out.println("Object2 is in the lock with Object1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}
}
