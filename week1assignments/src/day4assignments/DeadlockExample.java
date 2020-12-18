/**
 * 
 */
package day4assignments;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author c-mchao
 *
 */
public class DeadlockExample {

	/*
	 * Below we are instantiating new Integer 's; setting Integer i1 = 0 and Integer i2 = 0 would
	 * use equal references and mess up the example (as I found); 
	 * an alternative option is: 
	 * private static volatile int i1 = 0; 
	 * private static volatile int i2 = 0;
	 * private static Object lock1 = new Object(); 
	 * private static Object lock2 = new Object();
	 * and having synchronized(lock1) and synchronized(lock2), rather than synchronized(i1) and synchronized(i2)
	 * but https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
	 * gives a warning about this approach
	 */
	private static volatile Integer i1 = new Integer(0);
	private static volatile Integer i2 = new Integer(0);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {

				synchronized (i1) {

					// Sleep, so that each thread obtains its first lock
					// before the other potentially obtains both locks.
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					synchronized (i2) {

						i1 = 5;
						i1 = 5;
					}

				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {

				synchronized (i2) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					synchronized (i1) {

						i1 = 4;
						i2 = 4;
					}
				}
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				// to demonstrate the point in the long comment above
				Integer j1 = 0;
				Integer j2 = 0;
				System.out.println("Two Integer objects are the same? " + (j1 == j2));
				Timer timer = new Timer();
//				TimerTask t = 
				timer.scheduleAtFixedRate(new TimerTask() {
					public void run() {
						System.out.println("Tick: i1=" + i1 + " and i2=" + i2);
					}
				}, 0, 1000);
			}
		};

		t3.start();
		t1.start();
		t2.start();

	}

}
