package com.test.rein.lock.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasic {
	
	private Lock lockA = new ReentrantLock();
	private Lock lockB = new ReentrantLock();

	public void execute() {
		new Thread(this::processThis).start();
		new Thread(this::processThat).start();
	}
	
	public void processThis() {
		lockA.lock();
		System.out.println("LockA acquired by "+Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lockB.lock();
		System.out.println("LockB acquired by "+Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		lockA.unlock();
		lockB.unlock();
	}
	
	public void processThat() {
		lockB.lock();
		System.out.println("LockB acquired by "+Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lockA.lock();
		System.out.println("LockA acquired by "+Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lockB.unlock();
		lockA.unlock();
	}

}
