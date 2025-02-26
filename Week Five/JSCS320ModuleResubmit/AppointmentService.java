import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add an appointment set by it's unique ID.
    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("This appointment already exists or is invalid.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by searching there unique appointmentId.
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("This appointment ID does not exist.");
        }
        appointments.remove(appointmentId);
    }

    // Update an appointment's date or description.
    public void updateAppointment(String appointmentId, Date newDate, String newDescription) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("This appointment ID does not exist.");
        }
        Appointment appointment = appointments.get(appointmentId);
        appointment.setAppointmentDate(newDate);
        appointment.setDescription(newDescription);
    }
}