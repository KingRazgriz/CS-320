package AppointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment_validAppointment_shouldAddSuccessfully() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);
        assertNotNull(service.getAppointment("2225678900"), "Appointment should be added successfully.");
    }

    @Test
    public void testAddAppointment_nullAppointment_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        }, "Adding a null appointment should throw an exception.");
    }

    @Test
    public void testAddAppointment_duplicateAppointment_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        }, "Adding a duplicate appointment should throw an exception.");
    }

    @Test
    public void testDeleteAppointment_existingAppointment_shouldDeleteSuccessfully() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);
        service.deleteAppointment("1234567890");

        assertNull(service.getAppointment("2225678900"), "Appointment should be deleted successfully.");
    }

    @Test
    public void testDeleteAppointment_nonExistentAppointment_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("9999999999");
        }, "Deletion a non-existent appointment should throw an exception.");
    }

    @Test
    public void testDeleteAppointment_nullId_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment(null);
        }, "Deletion of a null ID should throw an exception.");
    }

    @Test
    public void testUpdateAppointment_validUpdate_shouldUpdateSuccessfully() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);

        Date newDate = new Date(System.currentTimeMillis() + 200000);
        String newDescription = "Updated description.";
        service.updateAppointment("2225678900", newDate, newDescription);

        Appointment updatedAppointment = service.getAppointment("2225678900");
        assertEquals(newDate, updatedAppointment.getDate(), "Appointment date should be updated.");
        assertEquals(newDescription, updatedAppointment.getDescription(), "Appointment description should be updated.");
    }

    @Test
    public void testUpdateAppointment_nullDate_shouldNotUpdateDate() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);

        service.updateAppointment("2225678900", null, "Updated description.");

        Appointment updatedAppointment = service.getAppointment("2225678900");
        assertEquals(futureDate, updatedAppointment.getDate(), "Appointment date should not be updated if new date is null.");
        assertEquals("Updated description.", updatedAppointment.getDescription(), "Appointment description should be updated.");
    }

    @Test
    public void testUpdateAppointment_nullDescription_shouldNotUpdateDescription() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);

        Date newDate = new Date(System.currentTimeMillis() + 200000);
        service.updateAppointment("2225678900", newDate, null);

        Appointment updatedAppointment = service.getAppointment("2225678900");
        assertEquals(newDate, updatedAppointment.getDate(), "Appointment date should be updated.");
        assertEquals("Valid description.", updatedAppointment.getDescription(), "Appointment description should not be updated if new description is null.");
    }

    @Test
    public void testUpdateAppointment_nonExistentAppointment_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        Date newDate = new Date(System.currentTimeMillis() + 200000);
        String newDescription = "Updated description.";

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAppointment("9999999999", newDate, newDescription);
        }, "Updating a non-existent appointment should throw an exception.");
    }

    @Test
    public void testGetAppointment_existingAppointment_shouldReturnAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid description.");

        service.addAppointment(appointment);
        Appointment retrievedAppointment = service.getAppointment("2225678900");

        assertEquals(appointment, retrievedAppointment, "Retrieved appointment should match the added appointment.");
    }

    @Test
    public void testGetAppointment_nonExistentAppointment_shouldReturnNull() {
        AppointmentService service = new AppointmentService();
        assertNull(service.getAppointment("9999999999"), "Retrieving a non-existent appointment should return null.");
    }
}