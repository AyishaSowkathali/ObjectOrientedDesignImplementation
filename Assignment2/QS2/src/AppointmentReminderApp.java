import javax.swing.SwingUtilities;

/**
 * 
 * @author Ayisha S.R. Sowkathali, Sifaben Vahora
 * 
 *         Appointment Reminder Application
 *
 */
public class AppointmentReminderApp {

	public static void main(String[] args) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ReminderFile();
			}
		});
	}

}
