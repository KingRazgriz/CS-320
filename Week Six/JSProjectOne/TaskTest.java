package TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation_validInput_shouldCreateTask() {
        Task task = new Task("2225678900", "Task Name", "Task Description");
        assertEquals("2225678900", task.getUniqueId(), "Task ID should match the input.");
        assertEquals("Task Name", task.getName(), "Task name should match the input.");
        assertEquals("Task Description", task.getDescription(), "Task description should match the input.");
    }

    @Test
    public void testTaskIdConstraints() {
        // Test null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description");
        }, "Task ID cannot be null.");

        // Test ID exceeding 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("22256789001", "Task Name", "Task Description"); // 11 characters
        }, "Task ID cannot exceed 10 characters.");

        // Test ID exactly 10 characters (valid case)
        assertDoesNotThrow(() -> {
            new Task("2225678900", "Task Name", "Task Description"); // 10 characters
        }, "Task ID should be valid if it is exactly 10 characters.");
    }

    @Test
    public void testTaskNameConstraints() {
        // Test null name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("2225678900", null, "Task Description");
        }, "Task name cannot be null.");

        // Test name exceeding 20 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("2225678900", "This name is way too long and should throw an exception.", "Task Description");
        }, "Task name cannot exceed 20 characters.");

        // Test name exactly 20 characters (valid case)
        assertDoesNotThrow(() -> {
            new Task("2225678900", "Exactly 20 chars!!", "Task Description"); // 20 characters
        }, "Task name should be valid if it is exactly 20 characters.");
    }

    @Test
    public void testTaskDescriptionConstraints() {
        // Test null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("2225678900", "Task Name", null);
        }, "Task description cannot be null.");

        // Test description exceeding 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("2225678900", "Task Name", "This description is way too long and should throw an exception because it exceeds 50 characters.");
        }, "Task description cannot exceed 50 characters.");

        // Test description exactly 50 characters (valid case)
        assertDoesNotThrow(() -> {
            new Task("2225678900", "Task Name", "This description is exactly 50 characters long!!!!!");
        }, "Task description should be valid if it is exactly 50 characters.");
    }

    @Test
    public void testTaskSetters_validInput_shouldUpdateSuccessfully() {
        Task task = new Task("2225678900", "Task Name", "Task Description");

        // Test valid name update
        task.setName("New Task Name");
        assertEquals("New Task Name", task.getName(), "Task name should be updated.");

        // Test valid description update
        task.setDescription("New Task Description");
        assertEquals("New Task Description", task.getDescription(), "Task description should be updated.");
    }

    @Test
    public void testTaskSetters_invalidInput_shouldThrowException() {
        Task task = new Task("2225678900", "Task Name", "Task Description");

        // Test setting null name
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        }, "Task name cannot be set to null.");

        // Test setting name exceeding 20 characters
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long and should throw an exception.");
        }, "Task name cannot exceed 20 characters.");

        // Test setting null description
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        }, "Task description cannot be set to null.");

        // Test setting description exceeding 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long and should throw an exception because it exceeds 50 characters.");
        }, "Task description cannot exceed 50 characters.");
    }
}