/**
 * 
 */
package day4assignments;

/**
 * @author c-mchao
 *
 */
public class DoubleCheckedSingleton {

	private static volatile int numRequests = 0;

	private static volatile DoubleCheckedSingleton _instance = null;

	/**
	 * @return the same instance of DoubleCheckedSingleton across all calls,
	 *         creating an instance if needed.
	 */
	public static DoubleCheckedSingleton getInstance() {

		if (_instance == null) {
			synchronized (DoubleCheckedSingleton.class) {
				_instance = new DoubleCheckedSingleton();
			}
		}

		synchronized (DoubleCheckedSingleton.class) {
			numRequests++;
		}

		return _instance;
	}

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			public void run() {
				DoubleCheckedSingleton s1 = getInstance();
				System.out
						.println(Thread.currentThread().getName() + ":  " + "Singleton's hash code: " + s1.hashCode());
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				DoubleCheckedSingleton s2 = getInstance();
				System.out
						.println(Thread.currentThread().getName() + ":  " + "Singleton's hash code: " + s2.hashCode());
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				DoubleCheckedSingleton s3 = getInstance();
				System.out
						.println(Thread.currentThread().getName() + ":  " + "Singleton's hash code: " + s3.hashCode());
			}
		};

		t1.start();
		t2.start();
		t3.start();

	}

	private DoubleCheckedSingleton() {

	}

}
