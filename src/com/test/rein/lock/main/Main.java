package com.test.rein.lock.main;

import com.test.rein.lock.deadlock.DeadLockBasic;

public class Main {
	
	public static void main(String[] args) {
		DeadLockBasic dlb = new DeadLockBasic();
		dlb.execute();
	}
}
