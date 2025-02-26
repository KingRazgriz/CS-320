package AppointmentService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        if (appointments.containsKey(appointment.getId())) {
            throw new IllegalArgumentException("Duplicate appointment ID not allowed.");
        }
        appointments.put(appointment.getId(), appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String id) {
        if (id == null || !appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(id);
    }

    // Update an existing appointment
    public void updateAppointment(String id, Date newDate, String newDescription) {
        Appointment appointment = appointments.get(id);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        if (newDate != null) {
            appointment.setDate(newDate);
        }
        if (newDescription != null) {
            appointment.setDescription(newDescription);
        }
    }

    // Get an appointment by ID (Optional, for verification)
    public Appointment getAppointment(String id) {
        return appointments.get(id);
    }
}
