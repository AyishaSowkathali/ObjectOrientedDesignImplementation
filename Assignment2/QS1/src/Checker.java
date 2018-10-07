import java.util.Queue;

/**
 * 
 * @author Ayisha S.R. Sowkathali, Sifaben Vahora
 * 
 *         Checker.java
 * 
 *         Class processes the passenger
 *
 */
public class Checker {

	long startTime = System.currentTimeMillis();
	long endTime = startTime + 15000;

	String checkerid;

	public String getCheckerid() {
		return checkerid;
	}

	public void setCheckerid(String checkerid) {
		this.checkerid = checkerid;
	}

	public Checker(String checkerid) {
		super();
		this.checkerid = checkerid;
	}

	public boolean processPassenger(Passenger passenger, Queue<Passenger> que) {
		new Thread(new Runnable() {
			public void run() {
				try {
					// peek queue
					while (System.currentTimeMillis() < endTime) {
						que.peek();
						Thread.sleep(1000);
					}
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getCheckerid() + " processing " + passenger.getPassengerId());
			}
		}).run();
		return true;
	}
}
