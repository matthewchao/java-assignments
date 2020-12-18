/**
 * 
 */
package day4assignments;

/**
 * @author matthew
 *
 */
public class ProducerConsumerExample {

	/**
	 * @param args
	 */

	/**
	 * buffer represents the items that are "produced"; buffer[i] = true means there
	 * is an item at index i. The produced items will always occupy a contiguous
	 * range [indexStart,indexEnd) and indexStart, indexEnd always belong to
	 * [0,CAPACITY) (possibly with circular wraparound; e.g., indexStart = 3 and
	 * indexEnd = 1 means that slots 3, 4, and 0 have items, while slots 1 and 2 do
	 * not). Producers will, if there is space, produce new items at slot indexEnd,
	 * and then increment indexEnd modulo CAPACITY Consumers will, if there are
	 * items, consume from indexStart, and then increment indexStart modulo CAPACITY
	 */
	private final static int CAPACITY = 5;
	private static volatile boolean[] buffer = new boolean[CAPACITY];
	private static int indexStart = 0;
	private static int indexEnd = 0;
	private static volatile Integer numInBuffer = new Integer(0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread c1 = getNewConsumer();
		Thread c2 = getNewConsumer();
		Thread p1 = getNewProducer();
		Thread p2 = getNewProducer();

		c1.start();
		c2.start();
		p1.start();
		p2.start();

	}

	private static Thread getNewConsumer() {
		return new Thread() {
			public void run() {
				while (true) {
					synchronized (ProducerConsumerExample.class) {
						if (numInBuffer > 0) {
							try {
								System.out.print("A consumer saw num was " + numInBuffer + " and made:  ");
								Thread.sleep(1000);
								assert buffer[indexStart];
								buffer[indexStart] = false;
								indexStart = (indexStart + 1) % CAPACITY;
								numInBuffer--;
								printBuffer();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							// nothing to consume!
						}
					}
				}
			}
		};
	}

	private static void printBuffer() {
		for (boolean x : buffer) {
			System.out.print(x ? "X " : "O ");
		}
		System.out.println();
	}

	private static Thread getNewProducer() {
		return new Thread() {
			public void run() {
				while (true) {

					synchronized (ProducerConsumerExample.class) {
						if (numInBuffer < CAPACITY) {

							try {
								Thread.sleep(1000);

								System.out.print("A producer saw num was " + numInBuffer + " and made:  ");
								assert !buffer[indexEnd];
								buffer[indexEnd] = true;
								indexEnd = (indexEnd + 1) % CAPACITY;
								numInBuffer++;
								printBuffer();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							// no space for more items!
						}
					}
				}
			}
		};
	}

}
