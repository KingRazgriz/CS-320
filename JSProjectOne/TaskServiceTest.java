package TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask_validTask_shouldAddSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertNotNull(service.getTask("2225678900"), "Task should be added and retrievable.");
    }

    @Test
    public void testAddTask_nullTask_shouldThrowException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(null);
        }, "Adding a null task should throw an exception.");
    }

    @Test
    public void testAddTask_duplicateTaskId_shouldThrowException() {
        TaskService service = new TaskService();
        Task task1 = new Task("2225678900", "Task Name", "Task Description");
        Task task2 = new Task("2225678900", "Another Task", "Another Description");

        service.addTask(task1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
        assertEquals("Task ID already exists.", exception.getMessage(), "Adding a duplicate task should throw an exception.");
    }

    @Test
    public void testDeleteTask_existingTask_shouldDeleteSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.deleteTask("2225678900");
        assertNull(service.getTask("2225678900"), "Task should be deleted and no longer retrievable.");
    }

    @Test
    public void testDeleteTask_nonExistentTask_shouldThrowException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("9999999999");
        }, "Deleting a non-existent task should throw an exception.");
    }

    @Test
    public void testUpdateTaskName_validName_shouldUpdateSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskName("2225678900", "Updated Task Name");
        assertEquals("Updated Task Name", service.getTask("2225678900").getName(), "Task name should be updated.");
    }

    @Test
    public void testUpdateTaskName_nullName_shouldThrowException() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("2225678900", null);
        }, "Updating task name to null should throw an exception.");
    }

    @Test
    public void testUpdateTaskName_longName_shouldThrowException() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("2225678900", "This name is way too long and should throw an exception.");
        }, "Updating task name to a value exceeding 20 characters should throw an exception.");
    }

    @Test
    public void testUpdateTaskDescription_validDescription_shouldUpdateSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskDescription("2225678900", "Updated Task Description");
        assertEquals("Updated Task Description", service.getTask("2225678900").getDescription(), "Task description should be updated.");
    }

    @Test
    public void testUpdateTaskDescription_nullDescription_shouldThrowException() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("2225678900", null);
        }, "Updating task description to null should throw an exception.");
    }

    @Test
    public void testUpdateTaskDescription_longDescription_shouldThrowException() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("2225678900", "This description is way too long and should throw an exception because it exceeds 50 characters.");
        }, "Updating task description to a value exceeding 50 characters should throw an exception.");
    }
}