import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author Ayisha S.R. Sowkathali, Sifaben Vahora
 * 
 *         QueueSystem class runs the main
 *
 */
public class QueueSystem {

	/*
	 * Main method instantiates 3 queues and 3 checkers. Passengers are added at
	 * random.
	 */
	public static void main(String[] args) throws InterruptedException {

		int queueASize = 30;
		int queueBSize = 20;
		int totalSize = queueASize + queueBSize;

		// Create 2 queues and 2 checkers
		LinkedBlockingQueue<Passenger> passengerQA = new LinkedBlockingQueue<Passenger>();
		LinkedBlockingQueue<Passenger> passengerQB = new LinkedBlockingQueue<Passenger>();

		Checker chkA = new Checker("Checker A");
		Checker chkB = new Checker("Checker B");

		// insert passengers into queue
		for (int i = 1; i <= totalSize; i++) {
			// generate a random number
			Random rn = new Random();
			int random = rn.nextInt(2) + 1;

			// Using mod to decide which queue the passengers go into
			if ((random % 2 == 0) && (passengerQA.size() <= queueASize)) {
				Passenger passenger = new Passenger("Passenger " + i, System.currentTimeMillis());
				System.out.println("Adding " + passenger.getPassengerId() + " to queue A");
				passengerQA.add(passenger);
			} else {
				if ((random % 2 == 1) && (passengerQB.size() <= queueBSize)) {
					Passenger passenger = new Passenger("Passenger " + i, System.currentTimeMillis());
					System.out.println("Adding " + passenger.getPassengerId() + " to queue B");
					passengerQB.add(passenger);
				}
			}
		}

		// Create Queue C and checker C
		LinkedBlockingQueue<Passenger> passengerQC = new LinkedBlockingQueue<Passenger>();
		Checker chkC = new Checker("Checker C");

		// Create 2 threads, one for each queue
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				Iterator<Passenger> iteratorA = passengerQA.iterator();
				while (iteratorA.hasNext()) {
					Passenger passenger = iteratorA.next();
					if (chkA.processPassenger(passenger, passengerQA)) {
						passengerQC.add(passenger);
						System.out.println("Queue C size: " + passengerQC.size());
					}
				}
			}
		};
		Thread t1 = new Thread(runnable1);
		t1.start();

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				Iterator<Passenger> iteratorB = passengerQB.iterator();

				while (iteratorB.hasNext()) {
					Passenger passenger = iteratorB.next();
					if (chkB.processPassenger(passenger, passengerQB)) {
						passengerQC.add(passenger);
						System.out.println("Queue C size: " + passengerQC.size());
					}
				}
			}
		};
		Thread t2 = new Thread(runnable2);
		t2.start();

		Runnable runnable3 = new Runnable() {
			@Override
			public void run() {
				Iterator<Passenger> iteratorC = passengerQC.iterator();

				while (iteratorC.hasNext()) {
					Passenger passenger = iteratorC.next();
					if (chkC.processPassenger(passenger, passengerQC)) {
						System.out.println("Queue C processed : " + passenger.getPassengerId());
						passengerQC.remove(passenger);
						System.out.println("Queue C removed : " + passenger.getPassengerId());
					}
				}
			}
		};
		Thread t3 = new Thread(runnable3);
		t3.start();
	}
}
