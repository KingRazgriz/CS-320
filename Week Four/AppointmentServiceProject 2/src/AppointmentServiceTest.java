import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        service.addAppointment(appointment);
        assertNotNull(service);
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        service.addAppointment(appointment);
        service.deleteAppointment("2225678900");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("2225678900");
        });
    }

    @Test
    public void testUpdateAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        service.addAppointment(appointment);

        Date newDate = new Date(System.currentTimeMillis() + 200000);
        service.updateAppointment("2225678900", newDate, "Updated Description.");
        assertEquals(newDate, appointment.getAppointmentDate());
        assertEquals("Updated Description.", appointment.getDescription());
    }
}