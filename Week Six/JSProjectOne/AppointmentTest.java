package AppointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation_validInput_shouldCreateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        assertNotNull(appointment, "Appointment should not be null when valid inputs are provided.");
    }

    @Test
    public void testInvalidAppointmentId_nullId_shouldThrowException() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Valid Description.");
        }, "Appointment ID cannot be null.");
    }

    @Test
    public void testInvalidAppointmentId_tooLongId_shouldThrowException() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("22256789001", futureDate, "Valid Description."); // 11 characters
        }, "Appointment ID cannot exceed 10 characters.");
    }

    @Test
    public void testInvalidAppointmentDate_pastDate_shouldThrowException() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", pastDate, "Valid Description.");
        }, "Appointment date cannot be in the past.");
    }

    @Test
    public void testInvalidDescription_nullDescription_shouldThrowException() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", futureDate, null);
        }, "Description cannot be null.");
    }

    @Test
    public void testInvalidDescription_tooLongDescription_shouldThrowException() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        String longDescription = "This description is way too long and should throw an exception because it exceeds 50 characters.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("2225678900", futureDate, longDescription);
        }, "Description cannot exceed 50 characters.");
    }

    @Test
    public void testValidDescription_exactly50Characters_shouldCreateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        String description = "This description is exactly fifty characters long.";
        Appointment appointment = new Appointment("2225678900", futureDate, description);
        assertNotNull(appointment, "Appointment should not be null when description is exactly 50 characters.");
    }

    @Test
    public void testValidAppointmentId_exactly10Characters_shouldCreateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("2225678900", futureDate, "Valid Description.");
        assertNotNull(appointment, "Appointment should not be null when ID is exactly 10 characters.");
    }
}
