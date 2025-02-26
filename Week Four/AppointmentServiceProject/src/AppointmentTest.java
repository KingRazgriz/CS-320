import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        assertNotNull(appointment);
    }

    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Valid Description.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", futureDate, "Valid Description.");
        });
    }

    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", pastDate, "Valid Description.");
        });
    }

    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", futureDate, "This description is way too long and should throw an exception.");
        });
    }
}