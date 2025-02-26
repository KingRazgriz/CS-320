package Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("2225678900", "Task Name", "Task Description");
        assertEquals("1234567890", task.getUniqueId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testTaskIdConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("2225678900", "Task Name", "Task Description"));
    }

    @Test
    public void testTaskNameConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Task("2225678900", null, "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("2225678900", "Please adjust name to character limit.", "Task Description"));
    }

    @Test
    public void testTaskDescriptionConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Task("2225678900", "Task Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("2225678900", "Task Name", "Please adjust description to character limit."));
    }

    @Test
    public void testTaskSetters() {
        Task task = new Task("2225678900", "Task Name", "Task Description");
        task.setName("Define new task name.");
        task.setDescription("Define new task description.");
        assertEquals("Define new task name.", task.getName());
        assertEquals("Define new task description.", task.getDescription());
    }
}
