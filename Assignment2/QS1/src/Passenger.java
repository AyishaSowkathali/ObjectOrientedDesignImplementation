/**
 * 
 * @author Ayisha S.R. Sowkathali, Sifaben Vahora
 * 
 *         Passenger.java implements queue methods
 *
 */
public class Passenger {

	private String passengerId;
	private long time;

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Passenger(String passengerId, long time) {
		super();
		this.passengerId = passengerId;
		this.time = time;
	}
}
