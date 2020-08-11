package com.test.sync.deadlock.threads;

public class Thread2  extends Thread {
	private Object object1;
	private Object object2;
	
	public Thread2(Object o1, Object o2) {
		this.object1 = o1;
		this.object2 = o2;
	}
	
	@Override
	public void run() {
		synchronized (object2) {
			System.out.println("Object2 is in the lock & waiting for Object1 for lock");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		synchronized (object1) {
			System.out.println("Object1 is in the lock with Object 2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}
}
